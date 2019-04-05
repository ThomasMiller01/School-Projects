
import java.util.Scanner;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thomas.miller
 */
public class ViginereVerschluesselung {

    static ArrayList<String> alphabetDict = new ArrayList<>();       
    
    public static void main(String[] args) { 
        addAlphabetDict();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Schluessel:");            
            String key = sc.next();       	             
            System.out.println("String zu Verschluesseln:");
            String startString = sc.next();
            startString += sc.nextLine();
            System.out.println("String: " + startString + ", SChluessel: " + key);
            System.out.println("Encrypt:");
            System.out.println(encrypt(startString, key.toLowerCase().toCharArray()));            
        }                
    }
    
    static void addAlphabetDict(){
        String alp = "abcdefghijklmnopqrstuvwxyz";
        for(char c: alp.toCharArray()){
            alphabetDict.add(String.valueOf(c));
        }
    }
    
    static String encrypt(String str, char[] key){    
        int kIndex = 0;
        String encryptedKey = "";
        for(char b: str.toLowerCase().toCharArray()){
            int index = alphabetDict.indexOf(String.valueOf(b));
            if(index == -1){
                encryptedKey += String.valueOf(b);
            }
            else{
                if(kIndex > key.length - 1){
                    kIndex = 0;
                }
                int kIndex2 = alphabetDict.indexOf(String.valueOf(key[kIndex]));                
                int newIndex = (kIndex2 + index) % alphabetDict.size();                
                encryptedKey += alphabetDict.get(newIndex);
                kIndex ++;
            }
        }
        return encryptedKey;
    }    
}
