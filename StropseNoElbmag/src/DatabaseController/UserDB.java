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
public class UserDB {
    
    DBParser parser;
    
    public boolean add(String userName, String password, String email)
    {
        boolean result = parser.addUser(userName, password, email);
        return result;
    }
}
