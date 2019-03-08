import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thomas.miller
 */
public class WordDatabase {    
    Connection connection;
    String db_path = System.getProperty("user.dir") + "\\Database\\" + "wiki.db";
    
    public WordDatabase(boolean debug){
        init(debug);
    }
    
    void init(boolean debug){
        try {
            if(debug){
                System.out.println("[WordDatabase] Creating Connection to Database...");
            }            
            connection = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            if (!connection.isClosed())
                if(debug){
                    System.out.println("[WordDatabase] ...Connection established"); 
                }                                
            Statement stmt = connection.createStatement();            
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS wiki (word, definition);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    Map<String, String> loadWords(boolean debug){
        if(debug){
            System.out.println("[WordDatabase] Loading words ...");
        }
        Map<String, String> wiki = new HashMap<String, String>();
        try{            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM wiki;");
            while (rs.next()) {                
                String word = rs.getString("word");
                String definition = rs.getString("definition");
                if(debug){
                    System.out.println("[WordDatabase] word = " + word + ", definition = " + definition);                                    
                }                 
                wiki.put(word, definition);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }       
        return wiki;
    }
}
