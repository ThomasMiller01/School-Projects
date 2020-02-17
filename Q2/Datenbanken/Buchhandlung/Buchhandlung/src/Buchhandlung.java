
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class Buchhandlung {

    /**
     * @param args the command line arguments
     */
    static DatabaseConnector databaseConnector;
    
    static ArrayList<Kunde> kunden = new ArrayList<>();
    
    static ArrayList<Kunde> verspaetungsliste = new ArrayList<>();
    
    public static void main(String[] args) {
        connect("D:\\Schule\\Q2\\Info\\Datenbanken\\BuchhandlungImplementation\\Aufgabe4.accdb");
        profilLaden();
        verspaetungenLaden();
        disconnect();
    }                     
    
    public static void profilLaden(){            
        String[][] kundenData = selectQuery("SELECT * FROM Kunde");                    
        for(int i = 0; i < kundenData.length; i++){
            String[][] bestellungenData = selectQuery("SELECT * FROM bestellt WHERE Benutzername = '" + kundenData[i][0] + "'");              
            ArrayList<Bestellung> Bestellungen = new ArrayList<Bestellung>();
            if(bestellungenData != null){
                for(int j = 0; j < bestellungenData.length; j++){                    
                    String[] buchData = selectQuery("SELECT * FROM Buch WHERE ISBN = '" + bestellungenData[j][0] + "'")[0];                    
                    String[] verlagData = selectQuery("SELECT * FROM Verlag WHERE VID = '" + buchData[5] + "'")[0];
                    String[] darstellungData = selectQuery("SELECT * FROM Darstellung WHERE ISBN = '" + buchData[0] + "'")[0];                                        
                    Bestellungen.add(new Bestellung(new Buch(Integer.parseInt(buchData[0]), buchData[1], buchData[2], Float.parseFloat(buchData[3]), buchData[4], new Verlag(Integer.parseInt(verlagData[0]), verlagData[1], verlagData[2], verlagData[3]), darstellungData[1], Boolean.parseBoolean(darstellungData[3])), Integer.parseInt(bestellungenData[j][2])));
                }
            }
            else{
                Bestellungen = null;
            }
            kunden.add(new Kunde(kundenData[i][0], kundenData[i][1], kundenData[i][2], kundenData[i][3], kundenData[i][4], kundenData[i][5], Bestellungen));
        }           
        System.out.println("data loaded ...");
    }
    
    public static void verspaetungenLaden(){
        System.out.println("VerspaetungsListe:");
        for(int i = 0; i < kunden.size(); i++){
            Kunde kunde = kunden.get(i);
            if(kunde.Bestellungen != null){
                for(int j = 0; j < kunde.Bestellungen.size(); j++){                    
                    if(!kunde.Bestellungen.get(j).buch.Lieferbar){                        
                        verspaetungsliste.add(kunde);
                        System.out.println("  - " + kunde.Benutzername + ", Buch: " + kunde.Bestellungen.get(j).buch.Titel);                        
                    }
                }
            }
        }        
    }
          
    public static void connect(String database_path){
        databaseConnector = new DatabaseConnector("", 0, database_path, "", "");
    }
    
    public static void disconnect(){
        databaseConnector.close();
    }
    
    public static String[][] selectQuery(String query){
        databaseConnector.executeStatement(query);
        QueryResult res = databaseConnector.getCurrentQueryResult();
        return res.getData();
    }    
}
