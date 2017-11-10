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

    public OutcomeCalculator(String name, int wins, int losses) {
        double outcomeS=wins/losses;
        OddsCalculator cal=new OddsCalculator(name,outcomeS);
    }

    public OutcomeCalculator(String name, int kills, int deaths, String Tname) {
        double outcomeS=kills/deaths;
        OddsCalculator cal=new OddsCalculator(name,outcomeS,Tname);
    }
    
}
