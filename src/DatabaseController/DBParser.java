/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseController;

import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jakec
 */
public class DBParser {

    static Team getTeam(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String dbName = "stropse_no_elbag";
    private static DBParser instance = null;
    private PreparedStatement preparedStatement;
    private DBConnector db;
    public DBParser() {
        instance = this;
        db = new DBConnector();
    }
    
  public static DBParser getInstance(){
    if(instance==null){
       instance = new DBParser();
      }
      return instance;
  }
  
  public boolean loginCheck(String u, String p) throws Exception{
      try {
      ResultSet resultSet = db.getResultSet("select uname, password from "+dbName+".users where uname = '"+u+"'");
        if(resultSet.next()){
            String u2 = resultSet.getString("uname");
            String p2 = resultSet.getString("password");
            if(p.equals(p2)){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    catch(Exception e){
        return false;
    }
  }
  
  public String[][] getAllTeams() throws Exception{
      try {
        ArrayList<String[]> arr = new ArrayList<String[]>();
        String[] sArr = new String[2];
        ResultSet resultSet = db.getResultSet("select id, team_name from "+dbName+".teams");
        while(resultSet.next()){
            sArr[0] = ""+resultSet.getInt("id");
            sArr[1] = resultSet.getString("team_name");
        }
        String[][] out = new String[arr.size()][2];
        for(int i = 0; i < arr.size(); i++){
           out[i][0] = arr.get(i)[0];
           out[i][1] = arr.get(i)[1];
        }
        return out;
        
    }
    catch(Exception e){
        String[][] out = new String[1][2];
        System.out.println(e);
        return out;
    }
  }
  
  public String[][] getLeaderboard(){
      try{
        ResultSet resultSet = db.getResultSet("select score, uname from "+dbName+".users");
         ArrayList<String[]> arr = new ArrayList<String[]>();
        String[] sArr = new String[2];
        while(resultSet.next()){
            sArr[0] = ""+resultSet.getInt("score");
            sArr[1] = resultSet.getString("uname");
            arr.add(sArr);
        }
        
        String[][] out = new String[arr.size()][2];
        for(int i = 0; i < arr.size(); i++){
           out[i][0] = arr.get(i)[0];
           out[i][1] = arr.get(i)[1];
        }
        return out;
      }
      catch(SQLException e){
        String[][] out = new String[1][2];
        out[0][0] = "Error";
        out[0][1] = ""+e;
        System.out.println(e);
        return out;
      }
  }
  
  public void updateWins(String uname){
        try {
            ResultSet rs = db.getResultSet("Select wins from "+dbName+" where uname = "+ uname+";");
            if(rs.next()){
                int x = rs.getInt("wins");
                preparedStatement = db.getConnect().prepareStatement("UPDATE ?.users set wins = ? where uname = ?");
                preparedStatement.setString(1, dbName);
                preparedStatement.setInt(2, x);
                preparedStatement.setString(1, dbName);
                db.execute(preparedStatement);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  
  public String[][] getPreviousBets(String uname){
  try{
        ResultSet resultSet = db.getResultSet("select BetID, amount, team, winner from "+dbName+".placed_bets where uname = "+uname+";");
         ArrayList<String[]> arr = new ArrayList<String[]>();
        String[] sArr = new String[5];
        while(resultSet.next()){
            int x = resultSet.getInt("BetID");
            ResultSet rs = db.getResultSet("select team1, team2 from "+dbName+".bets where BetID = "+x+";");
            sArr[0] = rs.getString("team1");
            sArr[1] = rs.getString("team2");
            sArr[2] = ""+resultSet.getInt("amount");
            sArr[3] = resultSet.getString("team");
            sArr[4] = resultSet.getString("winner");
            arr.add(sArr);
        }
        
        String[][] out = new String[arr.size()][5];
        for(int i = 0; i < arr.size(); i++){
           out[i][0] = arr.get(i)[0];
           out[i][1] = arr.get(i)[1];
           out[i][2] = arr.get(i)[2];
           out[i][3] = arr.get(i)[3];
           out[i][4] = arr.get(i)[4];
        }
        return out;
      }
      catch(SQLException e){
        String[][] out = new String[1][2];
        out[0][0] = "Error";
        out[0][1] = ""+e;
        System.out.println(e);
        return out;
      }
  }

    void update(int id, String name, Player[] players, double odds) {
         try{
            ResultSet rs = db.getResultSet("select teamID from "+dbName+".teams where teamName = "+name+";");
            int x = rs.getInt("TeamID");
            preparedStatement = db.getConnect()
                .prepareStatement("insert into "+dbName+".players values ( ?, ?, ?, ?)");
            // "myuser, webpage, datum, summery, COMMENTS from FEEDBACK.COMMENTS");
            // Parameters start with 1
            for(int i = 0; i < players.length  ; i++){
              preparedStatement.setInt(1, id);
              preparedStatement.setString(2, ""+players[i]);
              preparedStatement.setInt(3, x);
              preparedStatement.setDouble(4, odds);
              db.execute(preparedStatement);
            }
    } catch (Exception e) {
    }
    }
}
