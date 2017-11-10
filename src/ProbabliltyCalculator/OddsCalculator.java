/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProbabliltyCalculator;

import MachineLearningOpinion.OpinionCalculator;

/**
 *
 * @author Colum
 */
public class OddsCalculator {

    public OddsCalculator(String name, double outcomeS) {
        OpinionCalculator cal=new OpinionCalculator();
        double teamProb=outcomeS/cal.getOpinionValue();
    }

    public OddsCalculator(String name, double outcomeS, String Tname) {
        OpinionCalculator cal=new OpinionCalculator();
        double PlayerProb=outcomeS/cal.getOpinionValue();
    }
    
}
