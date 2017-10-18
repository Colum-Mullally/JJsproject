/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseController;

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
        String[][] out = DBParser.getAllTeams();
        return out;
    }
    
    public void update(int id, String name, Player[] players, double odds)
    {
        DBParser.update(id,name,players,odds);
    }
}
