/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiRestConnector;
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
            scores = new int[teamIDs.length];
            for(int h=0;h<teamIDs.length;h++)
            {
                pandaTeamStats = new URL(pandaURLBase,"teams/" + teamIDs[h] + "/matches?token=" + token + "&sort=id");
                conn = (HttpsURLConnection)pandaTeamStats.openConnection();
                
                jsonString2 = jsonString2.replaceAll("\"id\":.*?\"results\":", "\"results\":");
                jsonString2 = jsonString2.replaceAll(",\"serie_id\":.*?\"serie\":", "\\},");
                jsonString2 = jsonString2.replaceAll(",\\{\"id\":.*\\]\\}", "");
                jsonString2 = jsonString2.replaceAll(",\\{\"team_id\":.*?\\}", "");
                jsonString2 = jsonString2.replaceAll("\\{\"results\":\\[\\{\"team_id\":", "");
                jsonString2 = jsonString2.replaceAll(",\"score\":1\\}\\]\\}", "");
                jsonString2 = jsonString2.substring(1,jsonString2.length()-2);
                //jsonString2 = jsonString2.replaceAll("\\]\\},\\{", "\\]\\},\n\\{");
                
                String[]temp = jsonString2.split(",");
                for(int i=0;i<temp.length;i++)
                {
                    found = false;
                    for(int j=0;j<teamIDs.length&&!found;j++)
                    {
                        if(teamIDs[j].equals(temp[i]))
                        {
                            scores[j]++;
                            found = true;
                        }
                    }
                }
            }
            output = "Number of victories for all teams:\n";
            for(int i=0;i<teamIDs.length;i++)
            {
                output += teamNames[i] + ": " + scores[i] + " wins.\n";
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(RestTeamConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RestTeamConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
    }

}
