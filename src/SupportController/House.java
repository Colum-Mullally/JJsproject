/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportController;

import AccountManager.Account;

/**
 *
 * @author Colum
 */
public class House {

   private double amount,odds;
   private Account user;
 void TransferXpHouse(Account user,double amount, double odds) {
        this.amount=amount;
        this.odds=odds;
        this.user=user;
    }
    void Pay(){
        user.add(amount*odds);
    }
}
