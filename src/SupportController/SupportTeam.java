/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportController;

import AccountManager.BronzeUser;
import DatabaseController.Team;
import DatabaseController.TeamDB;

/**
 *
 * @author Colum
 */
public class SupportTeam {

    private int id;
    private double amount;
    private BronzeUser bUser;
    private TeamDB database;
    Team team;
    SupportTeam(int id, double amount) {
        this.id=id;
        this.amount=amount;
        database= new TeamDB();
        team=database.getTeam(id); 
        double odds=team.getTeamOdds();
        bUser.deductXP(amount);
        House temp= new House();
        temp.TransferXpHouse(amount,odds);
        
    }
    
}
