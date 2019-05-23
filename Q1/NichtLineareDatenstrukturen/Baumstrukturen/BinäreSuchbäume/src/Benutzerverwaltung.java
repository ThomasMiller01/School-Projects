/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thomas
 */
public class Benutzerverwaltung {        
    BinarySearchTree<Benutzerprofil> benutzer = new BinarySearchTree<>(); 
    
    public Benutzerverwaltung(){
        String[][] userArr = {{"Detlef", "detlef007"}, {"Dieter", "dieter123"}, {"Heinz", "heinzi776"} };        
        for(String[] user: userArr){
            benutzer.insert(new Benutzerprofil(user[0], user[1]));
        }
    }
    
    public void neuenBenutzerAnlegen(String pBenutzername, String pPw){
        benutzer.insert(new Benutzerprofil(pBenutzername, pPw));
    }
    
    public void nutzerLoeschen(String pBenutzername){
        benutzer.remove(new Benutzerprofil(pBenutzername, "nicht vorhanden"));
    }
    
    public boolean ProfilVorhanden(String pBenutzername){
        return benutzer.search(new Benutzerprofil(pBenutzername, "nicht vorhanden")) != null;
    }
}
