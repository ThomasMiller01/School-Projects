/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thomas.miller
 */
public class ShopServer extends Server{
    
    ShopServer(int pServerPort){        
        super(pServerPort); //Port
    }
    
    public void processNewConnection(String pClientIP, int pClientPort){
        System.out.println("[Server] New Connection: " + pClientIP + ", " + pClientPort);
        this.send(pClientIP, pClientPort, "Willkommen! Wählen Sie eine Größe und eine Farbe für Ihr T-Shirt.");                
    }
    
    public void processClosingConnection(String pClientIP, int pClientPort){
        System.out.println("[Server] Abmeldung ...");
        this.send(pClientIP, pClientPort, "Client wird abgemeldet ...");
    }
    
    public void processMessage(String pClientIP, int pClientPort, String pMessage){
        System.out.println("[Server] New Message: " + pMessage);
        String[] nachrichtTeil = pMessage.split(":");
        if(nachrichtTeil[0].equals("THSIRT")){
            this.send(pClientIP, pClientPort, "Die Groesse ist " + nachrichtTeil[1] + ", die Farbe ist " + nachrichtTeil[2] + " und es kostet 19,99 Euro! Bitte bestätigen Sie die Bestellung.");
        }
        else if(nachrichtTeil[0].equals("BESTAETIGUNG")){
            if (nachrichtTeil[1].equals("ja")){
                this.send(pClientIP, pClientPort, "Vielen Dank für ihre Bestellung.");
                closeConnection(pClientIP, pClientPort);
            }
            else if(nachrichtTeil[1].equals("nein")){
                closeConnection(pClientIP, pClientPort);
            }
            else{
                this.send(pClientIP, pClientPort, "Bitte geben sie ja oder nein ein.");
            }
        }
        else if(nachrichtTeil[0].equals("ABMELDEN")){
            closeConnection(pClientIP, pClientPort);
        }
        else{
            this.send(pClientIP, pClientPort, "Bitte korrigieren sie ihre Eingabe.");
        }
    }       
}
