/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.Math;
/**
 *
 * @author thomas.miller
 */
public class Bestellung {    
    public Bestellung(List<TShirt> pTShirt, List<Double> pPreis){
        this.pTShirt = pTShirt;
        this.pPreis = pPreis;
    }
    
    public List<TShirt> pTShirt;
    public List<Double> pPreis;
    
    public TShirt[] getTShirt(){        
        int i = 0;
        pTShirt.toFirst();
        while(pTShirt.hasAccess())
        {
            i++;
            pTShirt.next();
        }
        TShirt[] pShirts = new TShirt[i + 1];
        i = 0;
        pTShirt.toFirst();
        while(pTShirt.hasAccess())
        {
            i++;
            pShirts[i] = pTShirt.getContent();
            pTShirt.next();
        }
        return pShirts;
    }
    
    public double[] getPreis(){        
        int i = 0;
        pPreis.toFirst();
        while(pPreis.hasAccess())
        {
            i++;
            pPreis.next();
        }
        double[] pPreise = new double[i + 1];
        i = 0;
        pPreis.toFirst();
        while(pPreis.hasAccess())
        {
            i++;
            pPreise[i] = pPreis.getContent();
            pPreis.next();
        }
        return pPreise;
    }
    
    public long getCompletePrice(){
        Double allPrice = 0.0;
        pPreis.toFirst();
        while(pPreis.hasAccess())
        {
            allPrice += pPreis.getContent();
            pPreis.next();
        }
        return Math.round(allPrice);
    }
}
