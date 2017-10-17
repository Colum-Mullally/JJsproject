/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportController;
import AccountManager.*;
import DatabaseController.Player;
import DatabaseController.PlayerDB;
/**
 *
 * @author Colum
 */
public class SupportPlayer {
    private int id;
    private double amount;
    private BronzeUser bUser;
    private PlayerDB database;
    Player player;
    SupportPlayer(int id, double amount) {
        this.id=id;
        this.amount=amount;
        database= new PlayerDB();
        player=database.getPlayer(id);
        double odds=player.getPlayerOdds();
        bUser.deductXP(amount);
        House temp= new House();
        temp.TransferXpHouse(amount,odds);
    }
   
    
}
