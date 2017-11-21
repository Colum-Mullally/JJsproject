/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportController;

/**
 *
 * @author Colum
 */
public class Support {
    private int id;
    private String Pid;
    private double amount;
    Support(int id,String Pid,double amount){
        this.id=id;
        this.Pid=Pid;
        this.amount=amount;
        
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
