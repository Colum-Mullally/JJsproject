
package ApiRestConnector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.JSONObject;

public class RestTeamConnector {
    private URL pandascoreURL; 
    private String token="YOeSj7aUHe0yCft4uVWh6NiH1-RthxqvKu9RC6zT1PXlYnAUo50";
    private String jsonString1;
    private JSONObject json;
    private ArrayList <String> idList = new ArrayList <String>();
    RestTeamConnector() throws MalformedURLException{
  boolean found= false;
  for(int x = 0; found; x++){
           pandascoreURL= new URL("https://api.pandascore.co/teams/?page="+ x + "&token="+token+"&sort=id");
           try {
               HttpsURLConnection conn = (HttpsURLConnection) pandascoreURL.openConnection();
               jsonString1 = printContent(conn);
               idList.add(jsonString1);
           } catch (IOException ex) {
               Logger.getLogger(RestTeamConnector.class.getName()).log(Level.SEVERE, null, ex);
           }
  }
  for(int i =0;i<idList.size();i++){
      System.out.println(idList.get(i));
  }
    }
    private static String printContent(HttpsURLConnection conn){
	String output = "Invalid connection";
        if(conn!=null)
        {
            output = "";
            try 
            {
                BufferedReader br =
                    new BufferedReader(
			new InputStreamReader(conn.getInputStream()));

                String input;

                while ((input = br.readLine()) != null){
                output += input + "\n";
	   }
	   br.close();
           
            }
            catch (IOException ioe)
            {
                System.out.println(ioe.toString());
            }
       }
        return output;
   }
}
