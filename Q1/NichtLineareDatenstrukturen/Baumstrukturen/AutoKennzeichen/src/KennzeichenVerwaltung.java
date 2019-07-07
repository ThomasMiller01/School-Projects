
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
public class KennzeichenVerwaltung {        
    static BinarySearchTree<OrtsKennzeichen> kennzeichen = new BinarySearchTree<OrtsKennzeichen>();
    static ArrayList<OrtsKennzeichen> tmp_kennzeichen = new ArrayList<>();
    
    public static void main(String[] args) {                
        kennzeichen.insert(new OrtsKennzeichen("LG", new int[]{123, 400}));
        kennzeichen.insert(new OrtsKennzeichen("BX", new int[]{10, 20, 30}));
        kennzeichen.insert(new OrtsKennzeichen("PS", new int[]{17, 255, 999}));
        kennzeichen.insert(new OrtsKennzeichen("AB", new int[]{17, 455}));
        kennzeichen.insert(new OrtsKennzeichen("MT", 100));
        kennzeichen.insert(new OrtsKennzeichen("XT", new int[]{123, 543}));
        kennzeichen.insert(new OrtsKennzeichen("OS", new int[]{17, 28, 455}));     
               
        addKennzeichen("DD", new int[]{0});      
        addKennzeichen("LG", new int[]{0});  
        System.out.println("printing tree ...");
        printTree(kennzeichen, "");         
        gibOrte(999);
    }    
    
    static void addKennzeichen(String contraction, int[] number){        
        OrtsKennzeichen _kennzeichen = kennzeichen.search(new OrtsKennzeichen(contraction, number));
        if(_kennzeichen != null){                  
            kennzeichen.remove(_kennzeichen);            
            for(int num: number){                
                _kennzeichen.addNumber(num);   
            }                                   
            kennzeichen.insert(_kennzeichen);
        }                
        else{
            kennzeichen.insert(new OrtsKennzeichen(contraction, number));
        }
    }
    
    static void gibOrte(int num){
        System.out.println("Orte mit nummer " + Integer.toString(num) + ":");
        ArrayList<OrtsKennzeichen> _kennzeichen = new ArrayList<>();
        getOrtskennzeichen(kennzeichen);        
        for(OrtsKennzeichen _Ortskennzeichen: tmp_kennzeichen){
            String[] allNumbers = _Ortskennzeichen.getNumbersString().split(", ");
            for(String _num: allNumbers){
                if(Integer.parseInt(_num) == num){
                    _kennzeichen.add(_Ortskennzeichen);
                }
            }                                    
        }
        for(OrtsKennzeichen _OrtsKennzeichen: _kennzeichen){
            System.out.println("Contraction: " + _OrtsKennzeichen.contraction + ", Numbers: " + _OrtsKennzeichen.getNumbersString());
        }
    }
    
    static void getOrtskennzeichen(BinarySearchTree<OrtsKennzeichen> node)
    {
        if(node == null) return;
        OrtsKennzeichen content = node.getContent();                  
        if(content != null){
            tmp_kennzeichen.add(content);            
        }                
        getOrtskennzeichen(node.getLeftTree());                      
        getOrtskennzeichen(node.getRightTree());        
    }
    
    static void printTree(BinarySearchTree<OrtsKennzeichen> node, String prefix)
    {
        if(node == null) return;
        OrtsKennzeichen content = node.getContent();                  
        if(content != null){
            System.out.println(prefix + " + " + content.contraction + ", [" + content.getNumbersString() + "]");           
        }                
        printTree(node.getLeftTree() , prefix + " ");                
        printTree(node.getRightTree() , prefix + " ");        
    }
}
