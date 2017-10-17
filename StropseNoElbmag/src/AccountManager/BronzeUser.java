/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManager;

import AccountManager.Account;

public class BronzeUser extends Account{
    String userName;
    double balance;
    double maxSupport = 50;
    public BronzeUser(String uName, double bal){
        userName = uName;
        balance = bal;
    }
    
    @Override
    double getMaxSupport() {
        
        return maxSupport;
    }

    public void deductXP(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
