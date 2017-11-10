/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiLiveController;

import ApiRestConnector.RestPlayerConnector;
import JsonResultParser.ResultParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Colum
 */
public class LivePlayerConnector {
    LivePlayerConnector(){
         //switched to csv
        String filename="PlayerR.csv";
        String lineFromFile="";
        String fileElements[];
        Scanner in;
        File aFile;
        aFile= new File(filename);
        try {
        in= new Scanner(aFile);
        ResultParser parser= new ResultParser();
        while(in.hasNext())
        {
            lineFromFile=in.nextLine();
            parser.parse(lineFromFile);
            
        }
        in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RestPlayerConnector.class.getName()).log(Level.SEVERE, null, ex);
        }         
}
}
