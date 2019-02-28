/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thomas.miller
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {           
        
        /*testBestellungClass();*/
        
        String ServerIP = "127.0.0.1";
        int ServerPort = 7777;                
        
        ShopServer shopServer = new ShopServer(ServerPort);
        System.out.println("[Server] Running: " + shopServer.isOpen());
        ShopClient shopClient = new ShopClient(ServerIP, ServerPort);  
        while(!shopClient.isConnected()){
            System.out.println("[Client] Not connected ...");
        }
        System.out.println("[Client] Connected: " + shopClient.isConnected());       
    }    
    
    public static void testBestellungClass(){
        List<TShirt> pTShirt = new List<>();
        pTShirt.append(new TShirt("Blau", "M"));
        pTShirt.append(new TShirt("Rot", "S"));
        List<Double> pPreis = new List<>();
        pPreis.append(19.99);
        pPreis.append(9.99);
        Bestellung pBestellung = new Bestellung(pTShirt, pPreis);
        System.out.println(pBestellung.getCompletePrice());        
        System.out.println(pBestellung.getTShirt());
        System.out.println(pBestellung.getPreis());
    }
}