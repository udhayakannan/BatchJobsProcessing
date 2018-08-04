package com.batch.jobs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class Task {

   
    public static void main(String s[]) throws Exception {
       
        
    	   new Task().readcsv1(); 
    
        
    }
    
    

    
    public void readcsv1() {
       String csvFile = "Job_info.csv";
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        //	br.readLine();
            while ((line = br.readLine()) != null) {
            	if ( line.trim().length() == 0 ) {
            	    continue;  // Skip blank lines
            	  } // otherwise:
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
            //    System.out.println(country[0] +" "+ country[1] +" "+ country[2] +" "+ country[3] +" "+ country[4]);
                try {
                	if(country[0].equals("DATA FROM JOB:"))
                		System.out.print(country[1]+"     ");
                	else if(country[0].equals("EXECUTED ON DATE:"))
                		 System.out.print(country[1]	+"      "+country[2]+ "      " +country[3]+ "  " +country[4].trim()+"       ");
                	else if(country[0].equals("TOTAL TCB CPU TIME="))
                		 System.out.print(country[1]+"                   ");
                	else if(country[0].equals("TOTAL ELAPSED TIME=")) {
                		 System.out.print(country[1]);
                		 System.out.println("");
                	}
                }
                catch(Exception e) {
                	System.out.println("Error while reading line "+e.getMessage());
              
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }
    
    
}
