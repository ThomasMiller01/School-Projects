/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thomas.miller
 */
public class ShopClient extends Client{
    ShopClient(String pServerIP, int pServerPort){             
        super(pServerIP, pServerPort);        
    }
    
    public void groesseFarbeWaehlen(String pGroesse, String pFarbe){                
        this.send("THSIRT:" + pGroesse + ":" + pFarbe);        
    }
    
    public void bestaetigen(String pAntwort){        
        this.send("BESTAETIGUNG:" + pAntwort);
    }
    
    public void abmelden(){        
        this.send("ABMELDEN");
    }
    
    public void processMessage(String pMessage){
        System.out.println("[Client] New Message: " + pMessage);
        
        String pGroesse = "M";
        String pFarbe = "Blau";
        String pBestaetigung = "ja";
        
        if(pMessage.contains("Größe")){
            System.out.println("[Client] Wähle Groesse: " + pGroesse + ", Farbe: " + pFarbe);
            groesseFarbeWaehlen(pGroesse, pFarbe);
        }
        else if(pMessage.contains("bestätigen")){
            System.out.println("[Client] Bestaetigung: " + pBestaetigung);
            bestaetigen(pBestaetigung);
        }
        else if(pMessage.contains("abgemeldet")){
            System.out.println("[Client] Abmelden ...");
            abmelden();
        }
    }
}
