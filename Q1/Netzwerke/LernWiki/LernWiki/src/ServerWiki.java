/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thomas.miller
 */
public class ServerWiki extends Server {
    
    boolean debug;
    
    ServerWiki(int pServerPort, boolean debug){        
        super(pServerPort);
        this.debug = debug;
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
                    System.out.println("[Server] ConnectionAnswer: Server-Client: true");                     
                }
                else if(pMessage.contains("false")){
                    System.out.println("[Server] ConnectionAnswer: Server-Client: false");
                }
            }  
            else if(pMessage.contains("stable")){
                System.out.println("[Server] Connection: Stable");                
                this.send(pClientIP, pClientPort, "login:needed");
            }
        }
        else if(pMessage.contains("login")){
            System.out.println("login with msg: " + pMessage);
        }
        else if(pMessage.contains("ABMELDEN")){
            closeConnection(pClientIP, pClientPort);
        }    
        else{
            System.out.println("Unknown message");
        }
    }      
}
