/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class Bestellung {
    public Bestellung(Buch buch, int Anzahl){
        this.buch = buch;
        this.Anzahl = Anzahl;
    }
    
    public Buch buch;
    public int Anzahl;
}
