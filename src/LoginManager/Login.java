/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginManager;

import DatabaseController.AccountDB;

/**
 *
 * @author Colum
 */
public class Login {
    //private String username, password;
    //private CharacterChecker cChecker;What is this and what is it for?
    private AccountDB accountChecker;
    
    public Login()
    {
        accountChecker = new AccountDB();
    }
    
    public boolean verifyLogin(String nName, String nPass)
    {
        return accountChecker.check(nName, nPass);
    }
}
