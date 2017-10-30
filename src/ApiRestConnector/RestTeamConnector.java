/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiRestConnector;
import JsonResultParser.ResultParser;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Colum
 */
public class RestTeamConnector {
    public RestTeamConnector() throws FileNotFoundException{
        try {
            String token = "oc84ume5yB0v6OUFpMse0g-7wb65xBiC1W_HcZCqVB_OwLvWH6M";
            String jsonString1 = null, idString, nameString, jsonString2 = null, output;
            String[]teamIDs, teamNames;
            boolean found = false;
            int[]scores;
            URL pandaURLBase, pandaAllTeams, pandaTeamStats;
            pandaURLBase = new URL("https://api.pandascore.co/");
            pandaAllTeams = new URL(pandaURLBase,"teams?token=" + token + "&sort=id");
            HttpsURLConnection conn = (HttpsURLConnection)pandaAllTeams.openConnection();
            jsonString1 = jsonString1.replaceAll("\"players\":\\[.*?\\],", "");
            jsonString1 = jsonString1.replaceAll(",\"acronym\":.*?\\}{1,2},", "\\},");
            jsonString1 = jsonString1.substring(1,jsonString1.length()-2);
            //jsonString1 = jsonString1.replaceAll(",", ",\n");
            idString = jsonString1.replaceAll("\\{\"id\":", "");
            idString = idString.replaceAll("\"name\":.*?\\},", "");
            idString = idString.replaceAll("\".*","");
            teamIDs = idString.split(",");
            nameString = jsonString1.replaceAll("\\{\"id\":.*?:\"", "");
            nameString = nameString.replaceAll("\",\\}", "");
            nameString = nameString.replaceAll("\"\\}","");
            nameString = nameString.replaceAll("Royal Never Give Up\".*","Royal Never Give Up");
            teamNames = nameString.split(",");
            ResultParser temp=new ResultParser(pandaURLBase,token);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(RestTeamConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RestTeamConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
    }

}
