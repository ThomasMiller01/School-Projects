import java.util.Scanner;

public class LernWiki {   
    public static void main(String[] args) {                        
        boolean debug = true;
        
        String ServerIp = "127.0.0.1";
        int ServerPort  = 7777;
        
        ServerWiki serverWiki = new ServerWiki(ServerPort, debug); 
        if(debug){
            System.out.println("[Server] Running: " + serverWiki.isOpen());                        
        }              
        
        System.out.println("To start please type 'connect' ...");
        
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
                
        ClientWiki clientWiki = null;
        while(true){            
            if(input.contains("connect")){
                clientWiki = new ClientWiki(ServerIp, ServerPort, debug);
                if(debug){
                    System.out.println("[Client] Connected: " + clientWiki.isConnected()); 
                } 
                clientWiki.startConnectionTest();
            } 
            else if(input.contains("login")){
                System.out.println("Login:");
                System.out.println("Please type in your username:");
                String user = sc.next();
                if(debug){
                    System.out.println("[Client] Login initiated ...");
                }
                clientWiki.login(user);
            }
            else if(input.contains("logout")){
                clientWiki.abmelden();
            }
            else if(input.contains("wiki")){
                String word = sc.nextLine().replace(" ", "");
                if(input.equals("all")){
                    clientWiki.getListOfAllWords();
                }
                else{
                    clientWiki.getDefinition(word);
                }
            }
            else if(input.contains("cmd")){
                System.out.println("connect, login, logout, wiki [all, whatever], exit");
            }
            else if(input.equals("exit")){
                System.out.println("Exit initiated ...");
                sc.close();
                System.exit(0);
            }
            input = sc.next();
        }
    }
}