/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class Buch {
    public Buch(int ISBN, String Titel, String Author, float Preis, String Kategorie, Verlag verlag, String Bewertung, boolean Lieferbar){
        this.ISBN = ISBN;
        this.Titel = Titel;
        this.Author = Author;
        this.Preis = Preis;
        this.Kategorie = Kategorie;
        this.verlag = verlag;
        this.Bewertung = Bewertung;
        this.Lieferbar = Lieferbar;
    }
    
    public int ISBN;
    public String Titel;
    public String Author;
    public float Preis;
    public String Kategorie;
    public Verlag verlag;
    public String Bewertung;
    public boolean Lieferbar;
    
}
