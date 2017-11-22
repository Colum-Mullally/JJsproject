/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseController;

import SupportController.Observer;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Colum
 */
public class ResultDB {
   private final List<Observer> observers;
   private int state;

    public ResultDB() {
        this.observers = new ArrayList<Observer>();
        
    }

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      notifyAllObservers();
   }

   public void attach(Observer observer){
      observers.add(observer);		
   }

   public void notifyAllObservers(){
      for (Observer observer : observers) {
         observer.pay();
      }
   } 	
}
