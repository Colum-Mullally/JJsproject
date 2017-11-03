/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseController;

/**
 *
 * @author Jack
 */
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeamDB {
    private DataMapper dm = new DataMapper();
    private DataSuper ds;
    
    public TeamDB(){
        ds = dm.getParserType();
    }
    public Team getTeam(String name)
    {
        Team out = ds.getTeam(name);
        return out;
    }
    
    public String[][] showAllTeams()
    {
        try {
            String[][] out = ds.getAllTeams();
            return out;
        } catch (Exception ex) {
            Logger.getLogger(TeamDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void update(int id, String name, Player[] players, double odds)
    {
        ds.update(id,name,players,odds);
    }
}
