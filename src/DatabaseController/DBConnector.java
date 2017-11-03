package DatabaseController;
        
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DBConnector {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String dbName;
    private boolean connectionFlag = false;

    public void DBConnector(){
        
    }
    
    public void connectDataBase(){
        try{
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/"+dbName+"?"
                        + "user=username&password=password");

        // Statements allow to issue SQL queries to the database
        statement = (Statement) connect.createStatement();
        }
        catch(Exception e){
            connectionFlag = false;
            System.out.print("Error: "+e);
        }
    }
    
    public ResultSet getResultSet(String sqlStatement){
        try{
            resultSet = statement
                    .executeQuery(sqlStatement);
            return resultSet;
        }
        catch(SQLException e){
            System.out.print(e);
        }
        return resultSet;
    }
    
    Connection getConnect(){
        return connect;
    }
    
    void execute(PreparedStatement ps){
        try {
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
}
