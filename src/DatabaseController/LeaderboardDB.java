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
public class LeaderboardDB {
    private DataMapper dm = new DataMapper();
    private DataSuper ds;
    
    public LeaderboardDB(){
        ds = dm.getParserType();
    }
    
    public String[][] getLeaderBoard()
    {
        String[][] out = ds.getLeaderboard();
        return out;
    }
}
