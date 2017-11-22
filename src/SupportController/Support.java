/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportController;

import DatabaseController.PlayerDB;
import DatabaseController.TeamDB;

/**
 *
 * @author Colum
 */
public class Support {
    private String id;
    private String Pid;
    private double amount;
    Support(String id,String Pid){
 
        
    }

    public Support(String username) {
        id=username;
    }
   public String[][] getAllPlayers(){
       PlayerDB temp= new PlayerDB();
       return temp.showAllPlayers();
       
   }
   public String[][] getAllTeams(){
       TeamDB temp= new TeamDB();
       return temp.showAllTeams();
       
   }
    void Selection(int choice){
        if (choice==1)
        {
            SupportPlayer temp=new SupportPlayer(id,id,amount);
        }
        else if(choice==2)
        {
            SupportTeam temp=new SupportTeam(id,Pid,amount);
        }
    } 
}
