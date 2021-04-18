package client.side;

import java.io.*;
import java.net.*;

public class Client {

	// TODO: If you have your own Premium account credentials, put them down here:
	  private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
	  private static final String CLIENT_SECRET = "PUBLIC_SECRET";
	  private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";

	  /**
	   * Entry Point
	   */
	  public static void main(String[] args) throws Exception {
	    // TODO: Specify your translation requirements here:
	    String fromLang = "en";
	    String toLang = "ko";
	    String text = "Good Morning";

	    Client.translate(fromLang, toLang, text);
	  }

	  /**
	   * Sends out a WhatsApp message via WhatsMate WA Gateway.
	   */
	  public static void translate(String fromLang, String toLang, String text) throws Exception {
	    // TODO: Should have used a 3rd party library to make a JSON string from an object
	    String jsonPayload = new StringBuilder()
	      .append("{")
	      .append("\"fromLang\":\"")
	      .append(fromLang)
	      .append("\",")
	      .append("\"toLang\":\"")
	      .append(toLang)
	      .append("\",")
	      .append("\"text\":\"")
	      .append(text)
	      .append("\"")
	      .append("}")
	      .toString();

	    URL url = new URL(ENDPOINT);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setDoOutput(true);
	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
	    conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
	    conn.setRequestProperty("Content-Type", "application/json");

	    OutputStream os = conn.getOutputStream();
	    os.write(jsonPayload.getBytes());
	    os.flush();
	    os.close();

	    int statusCode = conn.getResponseCode();
	    System.out.println("Status Code: " + statusCode);
	    BufferedReader br = new BufferedReader(new InputStreamReader(
	        (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()
	      ));
	    
	    String output = br.readLine();
	   
	    conn.disconnect();
	    
	    // SENDING 
	    Socket s = new Socket("localhost", 4999);
		
		// Text view in client
		System.out.println("Current Text : " + text);
		
		// Send to server
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println(output);
		pr.flush();
		
		s.close();
	  }
}