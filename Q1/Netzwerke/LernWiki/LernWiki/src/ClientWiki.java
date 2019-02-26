/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thomas.miller
 */
public class ClientWiki extends Client {
    
    boolean debug;
    
    ClientWiki(String pServerIP, int pServerPort, boolean debug){         
        super(pServerIP, pServerPort);        
        this.debug = debug;
    }
    
    public void startConnectionTest(){       
        System.out.println("[Client] Start Connection ...");
        this.send("connection:Client-Server:test");
    }
    
    public void login(String user, String pass){
        if(debug){
            System.out.println("[Debug] [Client] Login with user: " + user + ", pass: " + pass);            
        }
        this.send("login:" + user + ":" + pass);
    }
    
    public void abmelden(){        
        this.send("ABMELDEN");
    }
    
    public void processMessage(String pMessage){
        if(debug){
            System.out.println("[Debug] [Client] New Message: " + pMessage);
        }                
        if(pMessage.contains("connection")){
            if(pMessage.contains("Client-Server")){ 
                if(pMessage.contains("true")){
                    System.out.println("[Client] ConnectionAnswer: Client-Server: true");                    
                }
                else if(pMessage.contains("false")){
                    System.out.println("[Client] ConnectionAnswer: Client-Server: false");
                }
            }
            else if(pMessage.contains("Server-Client")){
                if(pMessage.contains("test")){                    
                    this.send("connection:Server-Client:true");                    
                    this.send("connection:stable");
                }
            }            
        }
        else if(pMessage.contains("login")){
            if(pMessage.contains("needed")){
                System.out.println("[Client] Please login (type 'login') ...");
            }
            else if(pMessage.contains("true")){
                System.out.println("[Client] Your are logged in.");
            }
            else if(pMessage.contains("false")){
                System.out.println("[Client] Wrong username or password ...");
            }
        }
        else if(pMessage.contains("abgemeldet")){
            System.out.println("[Client] Client logged out ...");            
        }
        else{
            System.out.println("Unknown message");
        }
    }
}
