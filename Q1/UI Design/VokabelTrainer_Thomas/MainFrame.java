import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class MainFrame
{
    private JButton printlistbtn;
    private JButton checkbtn;
    private JButton addwordbtn;
    private JButton addlistbtn;
    private JButton startestbtn;
    private JButton deletewordbtn;
    private JButton deletelistbtn;
    private JPanel fortestpannel;
    private JPanel fororganisationpannel;
    private JPanel printlistpannel;
    private JPanel checkpannel;
    private JPanel checkpanneltmp;
    private JPanel addwordpannel;
    private JPanel addwordpanneltmp;
    private JPanel addlistpannel;
    private JPanel addlistpanneltmp;
    private JPanel starttestpannel;
    private JPanel deletewordpannel;
    private JPanel deletewordpanneltmp;
    private JPanel deletelistpannel;
    private JPanel deletelistpanneltmp;
    private JPanel selectedlistpannel;
    private JPanel selectedlistpanneltmp;
    private JScrollPane consolescrollpane;
    private JTextArea consoletextarea;
    private JTextField checktextfield;
    private JTextField addwordquestiontextfield;
    private JTextField addwordanswertextfield;
    private JTextField addlisttextfield;
    private JTextField deletewordtextfield;
    private JTextField deletelisttextfield;
    private JTextField selectedlisttextfield;
    
    Core core = new Core();
    String[] tmpWord = new String[3];
    boolean addWordsFromStart = true;
        
    public MainFrame()
    {
        initComponents();
        if(addWordsFromStart){
            try{
                core.addList(1);
                core.addList(2);
                core.addWord("tree", "Baum", 1);
                core.addWord("house", "Haus", 1);
                core.addWord("search", "suchen", 2);
            }
            catch(Exception e){
                printToConsole("Error:;" + e + "; ");
            }
        }          
    } 
    
    private void printToConsole(String s){
        String[] s2 = s.split(";");
        for(int i=0;i<s2.length;i++){
            consoletextarea.append(s2[i] + "\n");
        }
    }  
        
        private void printlistbtnmethod(java.awt.event.ActionEvent evt) { 
            try{
                String toprint = core.printLists();
                if(!toprint.isEmpty()){
                    printToConsole("--------------------;All Lists:;" + core.printLists() + "--------------------");
                }
                else{
                    printToConsole("--------------------;No lists available ...;--------------------");
            }
        }
        catch(Exception e){
            printToConsole(";Error:;" + e + ";;");
        }         
    }  
    
    private void starttestbtnmethod(java.awt.event.ActionEvent evt) { 
        try{
            printToConsole("All Lists:;" + core.printLists());
            core.startTest(Integer.parseInt(selectedlisttextfield.getText()));
            tmpWord = core.getNextWord();
            printToConsole("--------------------;Test Started!;--------------------;New Word:;Question: " + tmpWord[1] + ";--------------------;");
        }
        catch(Exception e){
            printToConsole("--------------------;Error:;" + e + ";--------------------");
        }         
    }                                        

    private void checkwordbtnmethod(java.awt.event.ActionEvent evt) {
        try{            
            printToConsole("--------------------;Your input was: " + checktextfield.getText() + ";Question was: " + tmpWord[1] + ";Answer was: " + tmpWord[2] + ";--------------------;Word is: " + core.checkWord(checktextfield.getText(), tmpWord[2]) + ";--------------------;");
            tmpWord = core.getNextWord();
            printToConsole("--------------------;New Word:;Question: " + tmpWord[1] + ";--------------------;");
        }
        catch(NullPointerException e){  
            printToConsole("--------------------;Test is over ...;--------------------");
        }
        catch(Exception e){
            printToConsole("--------------------;Error:;" + e + ";--------------------");
        }
    }                                        

    private void addlistbtnmethod(java.awt.event.ActionEvent evt) {
        try{
            core.addList(Integer.parseInt(addlisttextfield.getText()));
            printToConsole("--------------------;New List Id: " + addlisttextfield.getText() + " added.;--------------------");
            addlisttextfield.setText("List name ...");
        }
        catch(Exception e){
            printToConsole("--------------------;Error:;" + e + ";--------------------");
        }
    }                                        

    private void deletelistbtnmethod(java.awt.event.ActionEvent evt) {  
        try{
            core.deleteList(Integer.parseInt(deletelisttextfield.getText()));
            printToConsole("--------------------;List Id: " + deletelisttextfield.getText() + " deleted.;--------------------");
            deletelisttextfield.setText("List name ...");
        }
        catch(Exception e){
            printToConsole("--------------------;Error:;" + e + ";--------------------");
        }
    }                                        
    
    private void deletewordbtnmethod(java.awt.event.ActionEvent evt) {   
        try{
            core.deleteWord(Integer.parseInt(deletewordtextfield.getText()), Integer.parseInt(selectedlisttextfield.getText()));
            printToConsole("--------------------;Word Id: " + deletewordtextfield.getText() + " deleted.;--------------------");
            deletewordtextfield.setText("word id ...");
        }
        catch(Exception e){
            printToConsole("--------------------;Error:;" + e + ";--------------------");
        }
    }                                        

    private void addwordbtnmethod(java.awt.event.ActionEvent evt) {    
        try{
            core.addWord(addwordquestiontextfield.getText(), addwordanswertextfield.getText(), Integer.parseInt(selectedlisttextfield.getText()));        
            printToConsole("--------------------;New Word added:;Question: " + addwordquestiontextfield.getText() + ";Answer: " + addwordanswertextfield.getText() + ";--------------------");
            addwordquestiontextfield.setText("Question ...");
            addwordanswertextfield.setText("Asnwer ...");
        }
        catch(Exception e){
            printToConsole("--------------------;Error:;" + e + ";--------------------");
        }
    }
    
    private void initComponents(){
        JFrame myframe = new JFrame("MainFrame");
        myframe.setSize(1000, 600);        
        
        fortestpannel = new JPanel();
        fororganisationpannel = new JPanel();
        
        /**
         * Check Start
         */        
        
        checkbtn = new JButton();
        checkpannel = new JPanel();
        checktextfield = new JTextField();
        
        checkpannel.setBackground(new java.awt.Color(116, 188, 63));

        checktextfield.setText("your input ...");
        checktextfield.setPreferredSize(new Dimension(80, 20));
        
        checkbtn.setText("Check");
        checkbtn.setActionCommand("checkwordbtn");
        checkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkwordbtnmethod(evt);
            }
        });
        
        checkpannel.add(checktextfield);
        checkpannel.add(checkbtn);
        fortestpannel.add(checkpannel);
        
        /**
         * Check End
         * 
         * AddWord Start
         */

        addwordpannel = new JPanel();
        addwordpanneltmp = new JPanel();
        addwordquestiontextfield = new JTextField();
        addwordanswertextfield = new JTextField();
        addwordbtn = new JButton();
        
        addwordpannel.setBackground(new java.awt.Color(52, 73, 94));
        addwordpanneltmp.setPreferredSize(new Dimension(300, 40));
        addwordpanneltmp.setBackground(new java.awt.Color(198, 187, 192));

        addwordquestiontextfield.setText("Question ...");  
        addwordquestiontextfield.setPreferredSize(new Dimension(80, 20));
        addwordanswertextfield.setText("Answer ...");
        addwordanswertextfield.setPreferredSize(new Dimension(80, 20));
        
        addwordbtn.setText("Add Word");
        addwordbtn.setActionCommand("addwordbtn");
        addwordbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addwordbtnmethod(evt);
            }
        });
        
        addwordpannel.add(addwordquestiontextfield);
        addwordpannel.add(addwordanswertextfield);
        addwordpannel.add(addwordbtn);
        addwordpanneltmp.add(addwordpannel);
        fororganisationpannel.add(addwordpanneltmp);
        
        /**
         * AddWord End
         * 
         * AddList Start
         */
        
        addlistpannel = new JPanel();
        addlistpanneltmp = new JPanel();
        addlisttextfield = new JTextField();
        addlistbtn = new JButton();
        
        addlistpannel.setBackground(new java.awt.Color(52, 73, 94));
        addlistpanneltmp.setPreferredSize(new Dimension(300, 40));
        addlistpanneltmp.setBackground(new java.awt.Color(198, 187, 192));

        addlisttextfield.setText("List name ...");
        addlisttextfield.setPreferredSize(new Dimension(80, 20));
        
        addlistbtn.setText("Add List");
        addlistbtn.setActionCommand("addlistbtn");
        addlistbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addlistbtnmethod(evt);
            }
        });     
        
        addlistpannel.add(addlisttextfield);
        addlistpannel.add(addlistbtn);
        addlistpanneltmp.add(addlistpannel);
        fororganisationpannel.add(addlistpanneltmp);
        
        /**
         * AddList End
         * 
         * StartTest Start
         */

        starttestpannel = new JPanel();
        startestbtn = new JButton();        
        
        starttestpannel.setBackground(new java.awt.Color(234, 165, 21));
        
        startestbtn.setText("Start Test!");
        startestbtn.setActionCommand("starttestbtn");
        startestbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starttestbtnmethod(evt);
            }
        });
                
        starttestpannel.add(startestbtn);        
        fortestpannel.add(starttestpannel);
        
        /**
         * AddList End
         * 
         * PrintList Start
         */

        printlistpannel = new JPanel();
        printlistbtn = new JButton();
        printlistpannel.setBackground(new java.awt.Color(102, 102, 51));                
        
        printlistbtn.setText("PrintAllLists");
        printlistbtn.setActionCommand("printlistbtn");
        printlistbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printlistbtnmethod(evt);
            }
        });
                
        printlistpannel.add(printlistbtn);        
        fortestpannel.add(printlistpannel);        
        
        /**
         * PrintList End
         * 
         * DeleteWord Start
         */
        
        deletewordpannel = new JPanel();
        deletewordpanneltmp = new JPanel();
        deletewordbtn = new JButton();
        deletewordtextfield = new JTextField();
        
        deletewordpannel.setBackground(new java.awt.Color(211, 84, 0));
        deletewordpanneltmp.setPreferredSize(new Dimension(300, 40));
        deletewordpanneltmp.setBackground(new java.awt.Color(198, 187, 192));
        
        deletewordtextfield.setText("word id ..."); 
        deletewordtextfield.setPreferredSize(new Dimension(80, 20));
        
        deletewordbtn.setText("Delete Word");
        deletewordbtn.setActionCommand("deletewordbtn");
        deletewordbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletewordbtnmethod(evt);
            }
        });
        
        deletewordpannel.add(deletewordbtn);
        deletewordpannel.add(deletewordtextfield);
        deletewordpanneltmp.add(deletewordpannel);
        fororganisationpannel.add(deletewordpanneltmp);
        
        /**
         * DeleteWord End
         * 
         * DeleteList Start
         */
        
        deletelistpannel = new JPanel();
        deletelistpanneltmp = new JPanel();
        deletelistbtn = new JButton();
        deletelisttextfield = new JTextField();
        
        deletelistpannel.setBackground(new java.awt.Color(211, 84, 0));
        deletelistpanneltmp.setPreferredSize(new Dimension(300, 40));
        deletelistpanneltmp.setBackground(new java.awt.Color(198, 187, 192));
        
        deletelisttextfield.setText("List id ...");
        deletelisttextfield.setPreferredSize(new Dimension(80, 20));
        
        deletelistbtn.setText("Delete List");
        deletelistbtn.setActionCommand("deletelistbtn");
        deletelistbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletelistbtnmethod(evt);
            }
        });
        
        deletelistpannel.add(deletelistbtn);
        deletelistpannel.add(deletelisttextfield);
        deletelistpanneltmp.add(deletelistpannel);
        fororganisationpannel.add(deletelistpanneltmp);
        
        /**
         * DeleteList End
         * 
         * SelectedList Start
         */
        
        selectedlistpannel = new JPanel();
        selectedlistpanneltmp = new JPanel();
        selectedlisttextfield = new JTextField();
        
        selectedlistpannel.setBackground(new java.awt.Color(189, 195, 199));
        selectedlistpanneltmp.setPreferredSize(new Dimension(300, 40));
        selectedlistpanneltmp.setBackground(new java.awt.Color(198, 187, 192));

        selectedlisttextfield.setText("selected list ...");
        selectedlisttextfield.setPreferredSize(new Dimension(90, 20));
        
        selectedlistpannel.add(selectedlisttextfield);
        selectedlistpanneltmp.add(selectedlistpannel);
        fororganisationpannel.add(selectedlistpanneltmp);
        
        /**
         * SelectedList End
         * 
         * Console Start
         */
        
        consoletextarea = new JTextArea();
        consolescrollpane = new JScrollPane();                
        
        consolescrollpane.setViewportView(consoletextarea); 
        consolescrollpane.setPreferredSize(new Dimension(950, 250));
        
        /**
         * Console End
         */
        
        fortestpannel.setBackground(new java.awt.Color(198, 187, 192));
        fortestpannel.setPreferredSize(new Dimension(400, 300));
        fororganisationpannel.setBackground(new java.awt.Color(198, 187, 192));
        fororganisationpannel.setPreferredSize(new Dimension(400, 300));
        
        myframe.getContentPane().setLayout(new FlowLayout());
        myframe.getContentPane().add(fortestpannel);
        myframe.getContentPane().add(fororganisationpannel);
        myframe.getContentPane().add(consolescrollpane); 
        myframe.setVisible(true);        
    }
}
