/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginManager;

import DatabaseController.UserDB;

/**
 *
 * @author Jack
 */
public class Register {
    
    //private String username, password, email;
    private final UserDB account;
    
    public Register()
    {
        account = new UserDB();
    }
    
    public boolean registerUser(String nUser, String nPass, String nMail)
    {
        boolean out = account.add(nUser, nPass, nMail);
        return out;
    }
    
}
