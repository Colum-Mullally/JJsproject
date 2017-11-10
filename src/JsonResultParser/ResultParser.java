/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonResultParser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Colum
 */
public class ResultParser {
    private URL pandaURLBase, pandaTeamStats;
    private String token ;
    public ResultParser(URL pandaURLBase,String token){
        this.token=token;
        this.pandaURLBase=pandaURLBase;
    }

    public ResultParser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void TeamParser(String[] teamIDs,String[] teamNames)
    {
        HttpsURLConnection conn;
        String token = "oc84ume5yB0v6OUFpMse0g-7wb65xBiC1W_HcZCqVB_OwLvWH6M";
        String jsonString1 = null, idString, nameString, jsonString2 = null, output;
        boolean found = false;
        int[]scores;
        scores = new int[teamIDs.length];
            for(int h=0;h<teamIDs.length;h++)
            {
            try {
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
            } catch (MalformedURLException ex) {
                Logger.getLogger(ResultParser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ResultParser.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            output = "Number of victories for all teams:\n";
            for(int i=0;i<teamIDs.length;i++)
            {
                output += teamNames[i] + ": " + scores[i] + " wins.\n";
            }
    }

    public void parse(String lineFromFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
