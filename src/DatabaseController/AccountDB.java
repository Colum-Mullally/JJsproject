
package DatabaseController;

import AccountManager.Account;

/**
 *
 * @author Colum
 */
public class AccountDB {
        
    private DataMapper dm = new DataMapper();
    private DataSuper ds;
    
    public AccountDB(){
        ds = dm.getParserType();
    }
    public boolean check(String username, String password)
    {
        boolean out = ds.check(username, password);
        return out;
    }
    
    public Account getAccount(int id){
        return ds.getAccount(id);
    }
}