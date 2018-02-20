/**
 * 
 */
package org.cryptowatch.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author saadigebara
 *
 */
public class CryptoWatch {

	/**
	 * @param args
	 */

		// TODO Auto-generated method stub
	    public static void main(String[] args) {
	        JSONParser parser = new JSONParser();

	        try {         
	            URL oracle = new URL("https://api.livecoin.net/exchange/ticker"); // URL to Parse
	            URLConnection yc = oracle.openConnection();
	            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	            
	            String inputLine;
	            while ((inputLine = in.readLine()) != null) {               
	                JSONArray a = (JSONArray) parser.parse(inputLine);
	                
	                // Loop through each item
	                for (Object o : a) {
	                    JSONObject liveCoinFeed = (JSONObject) o;

/*	                    Long last = (Long) liveCoinFeed.get("last");
	                    System.out.println("Post last : " + last);*/

	                    String symbol = (String) liveCoinFeed.get("symbol");
	                    System.out.println("Post symbol : " + symbol);

	                    System.out.println("\n");
	                }
	            }
	            in.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }   
	    }   

}
