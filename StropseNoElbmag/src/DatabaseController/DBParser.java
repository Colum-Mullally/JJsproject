/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jakec
 */
public class DBParser {
    private String dbName = "stropse_no_elbag";
    private static DBParser instance = null;
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
  
  
}
