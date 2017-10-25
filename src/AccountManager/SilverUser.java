/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManager;

import AccountManager.Account;

public class SilverUser extends AccountDecorator{
    String userName;
    double balance;
    double maxSupport = 100;
    public SilverUser(Account ac){
     super(ac);
    }
    
    @Override
    public double getMaxSupport() {
        
        return maxSupport;
    }

    @Override
    public void pay(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double balance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
