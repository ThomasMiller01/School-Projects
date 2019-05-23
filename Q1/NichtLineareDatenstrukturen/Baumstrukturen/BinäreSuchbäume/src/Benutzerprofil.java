/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class Benutzerprofil implements ComparableContent<Benutzerprofil>{
    
    private String benutzername, pw;
    
    public Benutzerprofil(String pBenutzername, String pPw){
        benutzername = pBenutzername;
        pw = pPw;
    }
    
    public String getBenutzername(){
        return benutzername;        
    }
    
    public boolean isGreater(Benutzerprofil  pProfil){
        return this.getBenutzername().compareTo(pProfil.getBenutzername()) > 0;
    }
    
    public boolean isLess(Benutzerprofil  pProfil){
        return this.getBenutzername().compareTo(pProfil.getBenutzername()) < 0;
    }
    
    public boolean isEqual(Benutzerprofil  pProfil){
        return this.getBenutzername().compareTo(pProfil.getBenutzername()) == 0;
    }
}
