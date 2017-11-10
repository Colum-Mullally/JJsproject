/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import AccountManager.Account;
import DatabaseController.AccountDB;

/**
 *
 * @author Colum
 */
public class ViewStats {
    private double balance;
    private String uName;
    public ViewStats(int id){
        Account account= new AccountDB().getAccount(id);
        balance=account.balance();
        uName=account.Uname();
        
    }
    public double getBalance()
    {
        return balance;
    }
    public String getUname(){
        return uName;
    }
}
