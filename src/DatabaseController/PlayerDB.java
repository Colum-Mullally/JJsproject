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
public class PlayerDB {

    private DataMapper dm = new DataMapper();
    private DataSuper ds;
    
    public PlayerDB(){
        ds = dm.getParserType();
    }
    public Player getPlayer(int id)
    {
        Player out = ds.getPlayer(id);
        return out;
    }
    
    public String[][] showAllPlayers()
    {
        String[][] out = ds.getAllPlayers();
        return out;
    }
    
    public void update(String name, double odds, String tname)
    {
        ds.update(name, odds, tname);
    }

   
}
