/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Thomas
 */
public class BinäreSuchbäumeBenutzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Benutzerverwaltung verwaltung = new Benutzerverwaltung();
        System.out.println("Profil von Joseph vorhanden: " + verwaltung.ProfilVorhanden("Joseph"));  
        System.out.println("Inser Joseph");
        verwaltung.neuenBenutzerAnlegen("Joseph", "josephrockt123");
        System.out.println("Profil von Joseph vorhanden: " + verwaltung.ProfilVorhanden("Joseph"));  
        System.out.println("Remove Joseph");
        verwaltung.nutzerLoeschen("Joseph");
        System.out.println("Profil von Joseph vorhanden: " + verwaltung.ProfilVorhanden("Joseph"));  
    }
    
}
