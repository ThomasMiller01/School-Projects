
import jdk.nashorn.internal.objects.NativeArray;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class OrtsKennzeichen implements ComparableContent<OrtsKennzeichen>{
    public String contraction = null;
    public List<Integer> numbers = null;
    
    public OrtsKennzeichen(String contraction, int number){
        this.contraction = contraction;
        this.numbers = new List<Integer>();
        this.addNumber(number)        
    }
    
    public OrtsKennzeichen(String contraction, int[] numbers){
        this.contraction = contraction;
        this.numbers = new List<Integer>();
        for(int number: numbers){
            this.addNumber(number);            
        }        
    }
    
    public void addNumber(int number){
        if(this.numbers.isEmpty()){
            this.numbers.append(number);
        }
        else{
            boolean inserted = false;
            this.numbers.toFirst();
            while(this.numbers.hasAccess()){
                if(this.numbers.getContent() < number){
                   this.numbers.insert(number);
                   inserted = true;
                   break;
                }   
            }            
            if(!inserted){
                this.numbers.append(number);
            }
        }
    }
    
    public boolean isGreater(OrtsKennzeichen ortsKennzeichen){
        return this.contraction.compareTo(ortsKennzeichen.contraction) > 0;
    }
    
    public boolean isLess(OrtsKennzeichen ortsKennzeichen){
        return this.contraction.compareTo(ortsKennzeichen.contraction) < 0;
    }
    
    public boolean isEqual(OrtsKennzeichen ortsKennzeichen){
        return this.contraction.compareTo(ortsKennzeichen.contraction) == 0;
    }
}
