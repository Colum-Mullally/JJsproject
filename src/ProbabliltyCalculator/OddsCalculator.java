/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProbabliltyCalculator;

import DatabaseController.PlayerDB;
import DatabaseController.TeamDB;
import MachineLearningOpinion.OpinionCalculator;

/**
 *
 * @author Colum
 */
public class OddsCalculator {

    public OddsCalculator(){
        
    }
    
    public OddsCalculator(String name, double outcomeS) {
         TeamDB temp =new TeamDB();
        temp.update(name,getOdds(outcomeS));
        
    }

    public OddsCalculator(String name, double outcomeS, String Tname) {
        PlayerDB temp =new PlayerDB();
        temp.update(name,getOdds(outcomeS),Tname);
    }
    
    public double getOdds(double outcomeS){
        OpinionCalculator cal=new OpinionCalculator();
        double playerProb=outcomeS/cal.getOpinionValue();
        return playerProb;
    }
}
