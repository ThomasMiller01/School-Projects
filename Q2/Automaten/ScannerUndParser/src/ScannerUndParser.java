/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Thomas
 */
public class ScannerUndParser {

    static Scanner scanner = new Scanner();
    static Parser parser;
    
    public static void main(String[] args) {
        System.out.println("Scanner: " + Boolean.toString(scanner.scanne("lalelu#")));        
        System.out.println("Scanner: " + Boolean.toString(scanner.scanne("iuwhwd#")));
        parser = new Parser(scanner.tokenliste);
        System.out.println("Parser: " + Boolean.toString(parser.parse()));
    }
}
