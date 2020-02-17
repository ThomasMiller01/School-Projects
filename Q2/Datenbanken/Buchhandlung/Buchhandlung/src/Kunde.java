
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
public class Kunde {
    public Kunde(String Benutzername, String Passwort, String Vorname, String Nachname, String Adresse, String Email, ArrayList<Bestellung> Bestellungen){
        this.Benutzername = Benutzername;
        this.Passwort = Passwort;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Adresse = Adresse;
        this.Email = Email;
        this.Bestellungen = Bestellungen;
    }
    
    public String Benutzername;
    public String Passwort;
    public String Vorname;
    public String Nachname;
    public String Adresse;
    public String Email;
    public ArrayList<Bestellung> Bestellungen;
}
