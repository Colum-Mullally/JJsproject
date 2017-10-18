
package ApiRestConnector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;

public class RestPlayerConnector {
    private URL pandascoreURL; 
    private String token="YOeSj7aUHe0yCft4uVWh6NiH1-RthxqvKu9RC6zT1PXlYnAUo50";
    private String jsonString1;
    RestPlayerConnector(){
       
  
           
           try {
               pandascoreURL= new URL("https://api.pandascore.co/lol/players.json?page1&token="+token+"&sort=id");
               HttpsURLConnection conn = (HttpsURLConnection) pandascoreURL.openConnection();
               jsonString1 = printContent(conn);
             
           } catch (IOException ex) {
               Logger.getLogger(RestPlayerConnector.class.getName()).log(Level.SEVERE, null, ex);
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
