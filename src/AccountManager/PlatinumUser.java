/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManager;

import AccountManager.Account;

public class PlatinumUser extends AccountDecorator{
    String userName;
    double balance;
    double maxSupport = 400;
    public PlatinumUser(Account ac){
     super(ac);
    }
    
    @Override
    public double getMaxSupport() {
        
        return maxSupport;
    }
    @Override
    public double balance() {
      return  balance;
    }

    @Override
    public void deductXP(double amount) {
        balance-=amount;
    }

    @Override
    public void add(double amount) {
         balance+=amount;
    }

    @Override
    public String Uname() {
        return userName;
    }
    
    
}
