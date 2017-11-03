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
public class PlayerDB {

    public Player getPlayer(int id)
    {
        Player out = DBParser.getInstance().getPlayer(id);
        return out;
    }
    
    public String[][] showAllPlayers()
    {
        String[][] out = DBParser.getInstance().getAllPlayers();
        return out;
    }
    
    public void update(int id, String name, double odds)
    {
        DBParser.getInstance().update(id,name,odds);
    }

   
}
