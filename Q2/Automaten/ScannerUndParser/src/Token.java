/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class Token {
    String typ;
    String inhalt;
    
    public Token(String typ, String inhalt){
        this.typ = typ;
        this.inhalt = inhalt;
    }
    
    public String getTyp(){
        return this.typ;
    }
    
    public String getInhalt(){
        return this.inhalt;
    }
}
