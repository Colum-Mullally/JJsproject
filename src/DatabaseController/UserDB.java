/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseController;

/**
 *
 * @author Jack
 */
public class UserDB {
    private DataMapper dm = new DataMapper();
    private DataSuper ds;
    
    public UserDB(){
        ds = dm.getParserType();
    }
    
    public boolean add(String userName, String password, String email)
    {
        boolean result = ds.addUser(userName, password, email);
        return result;
    }
}
