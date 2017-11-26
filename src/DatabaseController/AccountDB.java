
package DatabaseController;

import AccountManager.Account;

/**
 *
 * @author Jack
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
    public void update(String username,double balance){
        ds.updateAccount(username, balance);
    }
    
    public Account getAccount(String id){
        return ds.getAccount(id);
    }
     public String getStats(String id){
        String output= ds.getStats(id);
        Account temp= getAccount(id);
        return (temp.Uname()+"Supported "+output+"times and now has a balance of"+temp.balance()+"XP");
    }
}
