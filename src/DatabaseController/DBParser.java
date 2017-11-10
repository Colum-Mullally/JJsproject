/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseController;

import AccountManager.Account;
import AccountManager.AccountFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jakec
 */
public class DBParser extends DataSuper{
    
    private String dbName = "stropse_no_elbag";
    private PreparedStatement preparedStatement;
    private DBConnector db;
    public DBParser(){
        DBConnector.getInstance().connectDataBase();
    }
    
  
  public boolean check(String u, String p){
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
  
  public String[][] getAllTeams(){
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
        ResultSet resultSet = db.getResultSet("select Bal, uname from "+dbName+".users");
         ArrayList<String[]> arr = new ArrayList<String[]>();
        String[] sArr = new String[2];
        while(resultSet.next()){
            sArr[0] = ""+resultSet.getDouble("Bal");
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
            preparedStatement = db.getConnect().prepareStatement("insert into "+dbName+".players values ( ?, ?, ?, ?)");
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

    boolean addUser(String userName, String password, String email) {
       try{
            preparedStatement = db.getConnect().prepareStatement("insert into "+dbName+".users values ( ?, ?, ?)");
                  preparedStatement.setString(1, userName);
                  preparedStatement.setString(2, password);
                  preparedStatement.setString(3, email);
                  db.execute(preparedStatement);
                return true;
        } catch (Exception e) {
            return false;
        }
    }

    Account getAccount(int id) {
        try {
            ResultSet rs = db.getResultSet("Select Bal, Uname from "+dbName+".users where ID = "+id+";");
            if(rs.next()){
                Double xp = rs.getDouble("Bal");
                String username = rs.getString("Uname");
                AccountFactory af = new AccountFactory();
                return af.getAccount(username, xp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    void update(String name, double odds, String tname) {
        try {
                ResultSet rs = db.getResultSet("Select Count(name) from "+dbName+".users where name = "+name+";");
                if(rs.getInt("Count(name)") > 1){
                    preparedStatement = db.getConnect().prepareStatement("UPDATE ?.players set odds = ? where name = ?");
                    preparedStatement.setString(1, dbName);
                    preparedStatement.setDouble(2, odds);
                    preparedStatement.setString(2, name);
                    db.execute(preparedStatement);
                }
                else{
                    preparedStatement = db.getConnect().prepareStatement("insert into ?.players values (?, ?, ?)");
                    preparedStatement.setString(1, dbName);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, tname);
                    preparedStatement.setDouble(4, odds);
            
                    db.execute(preparedStatement);
                }
        } catch (SQLException ex) {
            Logger.getLogger(DBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    String[][] getAllPlayers() {
    try {
        ArrayList<String[]> arr = new ArrayList<String[]>();
        String[] sArr = new String[2];
        ResultSet resultSet = db.getResultSet("select id, name from "+dbName+".players");
        while(resultSet.next()){
            sArr[0] = ""+resultSet.getInt("id");
            sArr[1] = resultSet.getString("name");
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

    Player getPlayer(String name) {
    try {
        ResultSet resultSet = db.getResultSet("select name, odds from "+dbName+".players where name = "+name+";");
        int id = 0;
        Double odds = null;
        if(resultSet.next()){
            id = resultSet.getInt("id");
            odds = resultSet.getDouble("odds");
        }
        return new Player(id, odds, name);
        
        }
        catch(Exception e){
            System.out.println("Error");
            return new Player(0, 0, "Error");
        }
    }

    Team getTeam(String name) {
        try {
        ArrayList<Player> arr = new ArrayList<Player>();
        ResultSet resultSet = db.getResultSet("select id, odds from "+dbName+".teams where Team_Name = "+name+";");
        int id = 0;
        Double odds = null;
        if(resultSet.next()){
            id  = resultSet.getInt("id");
            odds = resultSet.getDouble("odds");
        }
        resultSet = db.getResultSet("select id, name, odds from "+dbName+".players where team_name = "+name+";");
        String pname;
        Double podds;
        int pid;
        while(resultSet.next()){
            pid = resultSet.getInt("id");
            pname = resultSet.getString("name");
            podds = resultSet.getDouble("odds");
            arr.add(new Player(pid, podds, pname));
        }
        Player[] players = new Player[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            players[i] = arr.get(i);
        }
        return new Team(id, odds, name, players);
            
        }
        catch(Exception e){
            System.out.println("Error");
            return null;
        }
    }
}
