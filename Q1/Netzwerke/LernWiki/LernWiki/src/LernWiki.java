/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author thomas.miller
 */
public class LernWiki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                        
        boolean debug = true;
        
        String ServerIp = "127.0.0.1";
        int ServerPort  = 7777;
        
        ServerWiki serverWiki = new ServerWiki(ServerPort, debug); 
        if(debug){
            System.out.println("[Server] Running: " + serverWiki.isOpen());                        
        }      
        ClientWiki clientWiki = new ClientWiki(ServerIp, ServerPort, debug);
        if(debug){
            System.out.println("[Client] Connected: " + clientWiki.isConnected()); 
        } 
        
        System.out.println("To start please type 'connect' ...");
        
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
                
        while(true){
            if(input.contains("connect")){
                clientWiki.startConnectionTest();
            } 
            else if(input.contains("login")){
                System.out.println("Login:");
                System.out.println("Please type in your username:");
                String user = sc.next();
                System.out.println("Please type in your password:");
                String pass = sc.next();
                System.out.println("[Client] Login initiated ..."); 
                clientWiki.login(user, pass);                
            }   
            else if(input.equals("exit")){
                System.out.println("Exit initiated ...");
                System.exit(0);
            }
            input = sc.next();
        }          
    }          
}
