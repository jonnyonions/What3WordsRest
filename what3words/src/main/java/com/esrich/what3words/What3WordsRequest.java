package com.esrich.what3words;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class What3WordsRequest {
	

	private static String w3wMethod = "w3w";
	private static String positionMethod = "position";
	
	private String urlBase = null;
	private String apiKey = null;
	
	public enum W3WOperation {	    positionToW3W, W3WToPosition  	}


	public What3WordsRequest(String urlBase, String apiKey) {
		this.urlBase = urlBase;
		this.apiKey= apiKey;
		
	}
	
	public String RequestPosition(String search)
	{
		//throw error if 3 words not provided
		return getQueryResponse(generateUrl(W3WOperation.W3WToPosition,search));
	}
	
	public String RequestW3W(String search)
	{
		//"https://api.what3words.com/position?key=APIKEY&position=-26.385267,153.087262"
		return getQueryResponse(generateUrl(W3WOperation.positionToW3W,search));
		
	}
	
	private String getQueryResponse(String requestUrl)
	{
		String responseString = null;
		
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(requestUrl);
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;

			while ((output = br.readLine()) != null) {			
				responseString = output;
			}

			httpClient.getConnectionManager().shutdown();
			
		  } catch (ClientProtocolException e) {
			e.printStackTrace();
			responseString = "Error: " + e.getMessage();
		  } catch (IOException e) {
			e.printStackTrace();
			responseString = "Error: " + e.getMessage();
		  }
		
		return responseString;	
	}
	

	public String generateUrl(W3WOperation w3WOp, String search)
	{
		switch (w3WOp) {
		case W3WToPosition:
			return String.format("%s%s?key=%s&string=%s",urlBase, w3wMethod, apiKey, search);
		case positionToW3W: default:
			return String.format("%s%s?key=%s&position=%s",urlBase, positionMethod, apiKey, search);

		}
	}

}
