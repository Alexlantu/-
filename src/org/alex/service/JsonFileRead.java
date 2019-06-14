package org.alex.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class JsonFileRead {
	
	private String getDatafromFile(String fileName) {
	      
	     String Path="d:\\" + fileName+ ".json";
	     BufferedReader reader = null;
	     String laststr = "";
	     try {
	    	 FileInputStream fileInputStream = new FileInputStream(Path);
	         InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
	         reader = new BufferedReader(inputStreamReader);
	         String tempString = null;
	         while ((tempString = reader.readLine()) != null) {
	             laststr += tempString;
	          }
	         reader.close();
	     	} catch (IOException e) {
	     		e.printStackTrace();
	        } finally {
	        	if (reader != null) {
	        		try {
	        			reader.close();
	        		} catch (IOException e) {
	        			e.printStackTrace();
	                }
	           }
	       }
	       return laststr;
	   }
	
	public static void main(String[] args) {
		JsonFileRead jfr = new JsonFileRead();
		String data = jfr.getDatafromFile("city");
		System.out.println(data);
	}
	
}
