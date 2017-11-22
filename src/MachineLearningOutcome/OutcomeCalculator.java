/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MachineLearningOutcome;

import ProbabliltyCalculator.OddsCalculator;

/**
 *
 * @author Colum
 */
public class OutcomeCalculator {
    public OutcomeCalculator(){
        
    }

    public OutcomeCalculator(String name, int wins, int losses) {
        OddsCalculator cal=new OddsCalculator(name,OddsMaker(wins,losses));
    }

    public OutcomeCalculator(String name, int kills, int deaths, String Tname) {
        double outcomeS=kills/kills+deaths;
        OddsCalculator cal=new OddsCalculator(name,outcomeS,Tname);
    }
    public double OddsMaker(int wins, int losses){
        double outcomeS;
         int wl=wins+losses;
         System.out.println(wl);
         if(wl==0){
             outcomeS= 0.5;
         }
         else
            outcomeS=(double) wins/wl;
        return outcomeS;
    }
    
}
