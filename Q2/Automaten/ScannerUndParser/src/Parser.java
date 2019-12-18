/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class Parser {
    List<Token> tokenliste;
    Token aktuellesToken;
    
    public Parser(List<Token> _tokenliste){
        tokenliste = _tokenliste;
        tokenliste.toFirst();   
        aktuellesToken = tokenliste.getContent();
    }
    
    public boolean parse() {
        if (tokenliste.hasAccess() && pruefeS()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean pruefeS(){
        if (tokenliste.hasAccess() && aktuellesToken.getTyp() == "EGAL" || aktuellesToken.getTyp() == "ENDE"){
            aktuellesToken = nextToken();
            return pruefeA();
        }
        else{
            return false;
        }
    }
    
    public boolean pruefeA(){
        if (tokenliste.hasAccess() && (aktuellesToken.getTyp() == "EGAL" || aktuellesToken.getTyp() == "ENDE")){
            aktuellesToken = nextToken();
            return pruefeB();
        }
        else{
            return false;
        }
    }
    
    public boolean pruefeB(){
        if (tokenliste.hasAccess() && aktuellesToken.getTyp() == "ENDE"){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Token nextToken(){
        tokenliste.next();
        return tokenliste.getContent();
    }
}
