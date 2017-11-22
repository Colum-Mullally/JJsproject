/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportController;

import AccountManager.Account;
import DatabaseController.HistoryDB;
import DatabaseController.ResultDB;

/**
 *
 * @author Colum
 */
public class House extends Observer{

   private double amount,odds;
   private Account user;
 void TransferXpHouse(Account user,double amount, double odds) {
        this.amount=amount;
        this.odds=odds;
        this.user=user;
        this.house = new ResultDB();
        this.house.attach(this);
        HistoryDB archive=new HistoryDB();
        archive.placebet(user,amount,odds);
        }
    public void pay(){
        user.add(amount*odds);
    }
}
