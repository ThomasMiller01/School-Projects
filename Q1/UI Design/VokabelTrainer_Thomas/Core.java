

/**
* Write a description of class Core here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class Core
{
    List<List<vokabel>> mainList = new List<List<vokabel>>();
    List<vokabel> testList = new List<vokabel>();
    
    public Core()
    {
        /*addList(1);
        addList(2);
        addWord("q1", "a1", 1);
        addWord("q2", "a2", 1);
        addWord("q3", "a3", 2);
        printLists();*/
    } 
    
    public void addWord(String question, String answer, int ListId){
        List<vokabel> listToAdd = new List<vokabel>();
        int vokId = 0;
        mainList.toFirst();
        while(mainList.hasAccess()){
            List<vokabel> tmplist = mainList.getContent();
            tmplist.toFirst();
            if(tmplist.getContent().id == ListId){
                listToAdd = tmplist;
                tmplist.toLast();
                if(tmplist.getContent().question != "first"){
                    vokId = tmplist.getContent().id + 1;
                }   
                break;
            }
            else{
                mainList.next();
            }
        }
        listToAdd.append(new vokabel(question, answer, vokId));
    }
    
    public void deleteWord(int wordId, int ListId){
        List<vokabel> listToDelete = new List<vokabel>();
        mainList.toFirst();
        while(mainList.hasAccess()){
            List<vokabel> tmplist = mainList.getContent();
            tmplist.toFirst();
            if(tmplist.getContent().id == ListId){
                listToDelete = tmplist;   
                break;
            }
            else{
                mainList.next();
            }
        }
        listToDelete.toFirst();
        while(listToDelete.hasAccess()){
            if(listToDelete.getContent().id == wordId  && listToDelete.getContent().question != "first"){
                listToDelete.remove();
                break;
            }
            else{
                listToDelete.next();
            }
        }
    }
    
    public String printLists(){
        String toPrint = "";
        mainList.toFirst();
        while(mainList.hasAccess()){
            List<vokabel> tmplist = mainList.getContent();
            tmplist.toFirst();
            toPrint += "ListID: " + tmplist.getContent().id + ";";
            System.out.println("---------------------");
            System.out.println("ListID: " + tmplist.getContent().id);
            tmplist.next();
            while(tmplist.hasAccess()){
                toPrint += "VokabelID: " + tmplist.getContent().id + ", VokabelQuestion: " + tmplist.getContent().question + ", VokabelAnswer: " + tmplist.getContent().answer + ";";                
                System.out.println("VokabelID: " + tmplist.getContent().id + ", VokabelQuestion: " + tmplist.getContent().question + ", VokabelAnswer: " + tmplist.getContent().answer);
                tmplist.next();
            }
            mainList.next();
        }
        System.out.println("---------------------");
        return toPrint;
    }
    
    public void addList(int id){
        List<vokabel> tmplist = new List<vokabel>();
        tmplist.append(new vokabel("first", "", id));
        mainList.append(tmplist);
    }
    
    public void deleteList(int id){
        mainList.toFirst();
        while(mainList.hasAccess()){
            List<vokabel> tmplist = mainList.getContent();
            tmplist.toFirst();
            if(tmplist.getContent().id == id){
                mainList.remove();
                break;
            }
            else{
                mainList.next();
            }
        }
    }
    
    public List<vokabel> getWords(int listId){
        List<vokabel> vokabelToReturn = new List<vokabel>();
        List<vokabel> listToGet = new List<vokabel>();
        mainList.toFirst();
        while(mainList.hasAccess()){
            List<vokabel> tmplist = mainList.getContent();
            tmplist.toFirst();
            if(tmplist.getContent().id == listId){
                listToGet = tmplist;   
                break;
            }
            else{
                mainList.next();
            }
        }
        listToGet.toFirst();
        listToGet.next();
        while(listToGet.hasAccess()){
            vokabelToReturn.append(listToGet.getContent());
            listToGet.next();
        }
        return vokabelToReturn;
    }
    
    public void startTest(int listId){
        List<vokabel> words = getWords(listId);
        words.toFirst();
        while(words.hasAccess()){
            testList.append(words.getContent());
            words.next();
        }
        testList.toFirst();
        System.out.println("Test started ...");
    }
    
    public boolean checkWord(String q, String a){
        //System.out.println("q1: " + q);
        //System.out.println("a1: " + a);
        String qToLower = q.toLowerCase();
        String aToLower = a.toLowerCase();
        //System.out.println("q2: " + qToLower);
        //System.out.println("a2: " + aToLower);
        String qWhitespace = qToLower.replaceAll("\\s+","");
        String aWhitespace = aToLower.replaceAll("\\s+","");
        //System.out.println("q3: " + qWhitespace);
        //System.out.println("a3: " + aWhitespace);
        if(qWhitespace.equals(aWhitespace)){
            return true;
        }
        else {
            return false;
        }
    }
    
    public String[] getNextWord(){
        if(testList.hasAccess()){
            String[] toReturn = new String[3];
            toReturn[0] =  Integer.toString(testList.getContent().id);
            toReturn[1] = testList.getContent().question;
            toReturn[2] = testList.getContent().answer;
            System.out.println("Next word:");
            System.out.println("ID: " + toReturn[0]);
            System.out.println("Question: " + toReturn[1]);
            System.out.println("Answer: " + toReturn[2]);
            testList.next();
            return toReturn;
        }
        else{
            testList.toFirst();
            while(testList.hasAccess()){
                testList.remove();
                testList.next();
            }
            return null;
        }                    
    }
}
