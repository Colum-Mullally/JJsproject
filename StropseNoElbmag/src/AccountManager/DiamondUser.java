/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManager;

import AccountManager.Account;

public class DiamondUser extends Account{
    String userName;
    double balance;
    double maxSupport = 1000;
    public DiamondUser(String uName, double bal){
        userName = uName;
        balance = bal;
    }
    
    @Override
    double getMaxSupport() {
        
        return maxSupport;
    }
    
    
}
