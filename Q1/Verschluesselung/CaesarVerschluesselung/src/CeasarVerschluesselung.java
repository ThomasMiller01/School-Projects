/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author thomas.miller
 */
public class CeasarVerschluesselung {
    static char[] alphabetDict = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Anzahl an Verschiebungen:");
            int num = 0;
            try{
                num = Integer.parseInt(sc.next());
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }            	             
            System.out.println("String zu Verschlüsseln:");
            String startString = sc.next();
            startString += sc.nextLine();
            System.out.println("StartString: " + startString + ", StartNum: " + Integer.toString(num));
            System.out.println("Encrypt:");
            System.out.println(encrypt(startString, num));            
        }                
    }
    
    static String encrypt(String str, int num){      
        String newString = "";
        for(char b: str.toLowerCase().toCharArray()){
            int index = -1;
            for(int i=0;i<alphabetDict.length;i++){
                String dictChar = String.valueOf(alphabetDict[i]);
                String bChar = String.valueOf(b);
                if(dictChar.equals(bChar)){
                    index = i;
                    break;
                }
            }
            if(index == -1){
                newString += String.valueOf(b);
            }
            else{
                int newIndex = (index + num) % alphabetDict.length;
                newString += String.valueOf(alphabetDict[newIndex]);                  
            }
        }
        return newString;
    }       
}
