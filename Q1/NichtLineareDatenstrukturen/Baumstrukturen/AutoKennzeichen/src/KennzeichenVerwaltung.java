
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
    public static KennzeichenVerwaltung k;
    BinarySearchTree<OrtsKennzeichen> kennzeichen = new BinarySearchTree<OrtsKennzeichen>();
    
    public static void main(String[] args) {        
        this.k = new KennzeichenVerwaltung();
        this.k.kennzeichen.insert(new OrtsKennzeichen("LG", new int[]{123, 400}));
        kennzeichen.insert(new OrtsKennzeichen("BX", new int[]{10, 20, 30}));
        kennzeichen.insert(new OrtsKennzeichen("PS", new int[]{17, 255, 999}));
        kennzeichen.insert(new OrtsKennzeichen("AB", new int[]{17, 455}));
        kennzeichen.insert(new OrtsKennzeichen("MT", 100));
        kennzeichen.insert(new OrtsKennzeichen("XT", new int[]{123, 543}));
        kennzeichen.insert(new OrtsKennzeichen("OS", new int[]{17, 28, 455}));        
    }    
    
    public void addKennzeichen(String contraction, int number){
        
    }
    
}
