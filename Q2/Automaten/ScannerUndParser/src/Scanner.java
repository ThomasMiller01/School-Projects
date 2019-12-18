/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class Scanner {
    
    public List<Token> tokenliste = new List<Token>();
    Token aktuellesToken;
    boolean fehler = false;    
    
    public boolean scanne(String eingabe) {
        char erster, zweiter;
        int pos =0;
        while (eingabe.charAt(pos) != '#')
        {
            erster = eingabe.charAt(pos);
            zweiter = eingabe.charAt (pos+1);
            if (erster =='l' && zweiter == 'e'){
                this.aktuellesToken = new Token("EGAL", "le");
            }
            else if (erster =='l' && zweiter == 'a'){
                this.aktuellesToken = new Token("EGAL", "la");
            }
            else if (erster == 'l' && zweiter == 'u'){
                this.aktuellesToken = new Token("ENDE", "lu");
            }
            else{
                fehler = true;
                break;
            }
            pos = pos +2;
            tokenliste.append(aktuellesToken);
        }
        return true ? !fehler : false;                
    }    
}
