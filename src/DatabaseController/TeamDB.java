/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Colum
 */
public class TeamDB {
    
    public Team getTeam(int id)
    {
        Team out = DBParser.getTeam(id);
        return out;
    }
    
    public String[][] showAllTeams()
    {
        try {
            String[][] out = DBParser.getInstance().getAllTeams();
            return out;
        } catch (Exception ex) {
            Logger.getLogger(TeamDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void update(int id, String name, Player[] players, double odds)
    {
        DBParser.getInstance().update(id,name,players,odds);
    }
}