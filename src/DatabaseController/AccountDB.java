/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseController;

import AccountManager.Account;

/**
 *
 * @author Colum
 */
public class AccountDB {
    
    public boolean check(String username, String password)
    {
        boolean out = DBParser.getInstance().check(username, password);
        return out;
    }
    
    public Account getAccount(int id){
        return DBParser.getInstance().getAccount(id);
    }
}