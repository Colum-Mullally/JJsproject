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
public class LeaderboardDB {
    
    public String[][] getLeaderBoard()
    {
        String[][] out = DBParser.getLeaderBoard();
        return out;
    }
}
