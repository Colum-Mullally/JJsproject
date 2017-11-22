/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseController;

import AccountManager.Account;

/**
 *
 * @author Jack
 */
public class HistoryDB {private DataMapper dm = new DataMapper();
    private DataSuper ds;
    
    public HistoryDB(){
        ds = dm.getParserType();
    }
    public String[][] getHistory(String uname){
        return ds.getPreviousBets(uname);
        
    }

    public void placebet(Account user, double amount, double odds) {
      ds.placebet(user,amount,odds);
    }
    
}
