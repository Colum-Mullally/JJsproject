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

    public OddsCalculator(String name, double outcomeS) {
        OpinionCalculator cal=new OpinionCalculator();
        double teamProb=outcomeS/cal.getOpinionValue();
         TeamDB temp =new TeamDB();
        temp.update(name,teamProb);
        
    }

    public OddsCalculator(String name, double outcomeS, String Tname) {
        OpinionCalculator cal=new OpinionCalculator();
        double PlayerProb=outcomeS/cal.getOpinionValue();
        PlayerDB temp =new PlayerDB();
        temp.update(name,PlayerProb,Tname);
    }
    
}
