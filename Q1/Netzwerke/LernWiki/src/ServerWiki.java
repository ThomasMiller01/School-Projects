import java.util.HashMap;
import java.util.Map;
import jdk.nashorn.internal.objects.NativeArray;

public class ServerWiki extends Server {
    
    boolean debug;
    String currentUser = null;
    Map<String, String> wiki = new HashMap<String, String>();
    
    ServerWiki(int pServerPort, boolean debug){        
        super(pServerPort);
        this.debug = debug;
        fillDict();
    }
    
    public void fillDict(){
        wiki.put("Baum", "Baum ist Holz");
        wiki.put("Wassermelone", "Malte sehr intelligent ... nicht");        
    }
    
    public void login(String user, String pClientID, int pClientPort){
        if(currentUser == null){
            if(user.equals("Thomas")){
            this.send(pClientID, pClientPort, "login:true");
            System.out.println("[Server] Welcome " + user + "!");
            currentUser = user;            
            }
            else{
                this.send(pClientID, pClientPort, "login:false");
            }
        }
        else{
            System.out.println("[Server] You are already logged in as: " + currentUser);
        }
    }
    
    public void logout(){
        currentUser = null;
    }
    
    public void processNewConnection(String pClientIP, int pClientPort){
        if(debug){
            System.out.println("[Debug] [Server] New Connection: " + pClientIP + ", " + pClientPort); 
        }               
    }
    
    public void processClosingConnection(String pClientIP, int pClientPort){
        System.out.println("[Server] Abmeldung ...");
        this.send(pClientIP, pClientPort, "Client logged out ...");
    }
    
    public void processMessage(String pClientIP, int pClientPort, String pMessage){
        if(debug){
            System.out.println("[Debug] [Server] New Message: " + pMessage);      
        }                            
        if(pMessage.contains("connection")){            
            if(pMessage.contains("Client-Server")){ 
                if(pMessage.contains("test")){                    
                    this.send(pClientIP, pClientPort, "connection:Client-Server:true");   
                    this.send(pClientIP, pClientPort, "connection:Server-Client:test");
                }
            }
            else if(pMessage.contains("Server-Client")){
                if(pMessage.contains("true")){
                    if(debug){
                        System.out.println("[Server] ConnectionAnswer: Server-Client: true");                        
                    }                    
                }
                else if(pMessage.contains("false")){
                    if(debug){
                        System.out.println("[Server] ConnectionAnswer: Server-Client: false");
                    }                    
                }
            }  
            else if(pMessage.contains("stable")){
                System.out.println("[Server] Connection: Stable");                
                this.send(pClientIP, pClientPort, "login:needed");
            }
        }
        else if(pMessage.contains("login")){
            if(debug){
                System.out.println("[Debug] [Server] login with msg: " + pMessage);
            }     
            login(pMessage.split(":")[1], pClientIP, pClientPort);
        }
        else if(pMessage.contains("logout")){
            logout();
            closeConnection(pClientIP, pClientPort);
        }   
        else if(pMessage.contains("wiki")){
            if(debug){
                System.out.println("[Server] [Wiki] " + pMessage);   
            }            
            if(currentUser == null){
                System.out.println("[Server] Please login before accessing definitions ...");
            }
            else{
                if(pMessage.contains("all")){
                    String allWords = "";
                    for (Map.Entry<String, String> entry : wiki.entrySet()) {                        
                        allWords += entry.getKey() + ", ";                                                
                    }                    
                    this.send(pClientIP, pClientPort, "wikiall:" + allWords);
                }
                else{
                    String word = pMessage.replace("wiki:", "");                    
                    this.send(pClientIP, pClientPort, "wiki:" + word + ":" + wiki.get(word));                    
                }
            }
        }
    }      
}
