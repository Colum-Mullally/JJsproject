/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManager;

import AccountManager.Account;

public class BronzeUser implements Account{
    String userName;
    double balance;
    double maxSupport = 50;
    public BronzeUser(String uName, double bal){
        userName = uName;
        balance = bal;
    }
    public double getMaxSupport() {
        
        return maxSupport;
    }
    public double balance() {
        
        return balance;
    }

    public void deductXP(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pay(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
