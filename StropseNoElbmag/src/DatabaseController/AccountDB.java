/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseController;

/**
 *
 * @author Colum
 */
public class AccountDB {
    
    public boolean check(String username, String password)
    {
        boolean out = DBParser.check(username, password);
        return out;
    }
    
    public void getAccount(String username)
    {
        DBParser.getAccount(username);
    }
}
