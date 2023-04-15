package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
    public static void main(String[] args) {
        
    	//Sample code to read from file passed as command line argument
    	Scanner sc=null;
    	FileInputStream fis=null;
        try {
            // the file to be opened for reading
            fis = new FileInputStream(args[0]);
            sc = new Scanner(fis); // file to be scanned
            SubscriptionDetails subscriptionDetails = new SubscriptionDetails();
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                //Add your code here to process input commands
            	String[] line = sc.nextLine().split(" ");
            	try {
            		switch(line[0]) {
	            		case "START_SUBSCRIPTION": 
	            			subscriptionDetails.validateSubscriptionStartDate(line[1]);
	            			break;
	            			
	            		case "ADD_SUBSCRIPTION":
	            			subscriptionDetails.addSubscription(line[1], line[2]);
	            			break;
	            			
	            		case "ADD_TOPUP":
	            			subscriptionDetails.calculateTopupCharge(line[1], line[2]);
	            			break;
	            			
	            		case "PRINT_RENEWAL_DETAILS":
	            			subscriptionDetails.printRenewalDetails();
	            			break;
	            		
	            	}
            	}
            	catch (SubscriptionException e) {
            		System.out.println(e.getMessage());
				}
            }
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        finally {
        	sc.close(); // closes the scanner
        	try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // closes the file reader
        }
    }
    
}
