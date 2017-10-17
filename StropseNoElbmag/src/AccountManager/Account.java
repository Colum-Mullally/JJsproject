/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManager;
abstract class Account {
    private double balance;
    private String userName;
    
    abstract double getMaxSupport();
    
    private void pay(double amount){
        balance += amount;
    }
}
