package com.esrich.what3words;

/**
 * Hello world!
 *
 */
public class App 
{
	private static String coordinateString = "-26.385267,153.087262";
	private static String w3wString = "bond.eardrum.expose";

	private static String urlBase = "https://api.what3words.com/";
	
	private static String apiKey = "";
	
	
    public static void main( String[] args )
    {
		System.out.println("Output from What3Words .... \n");
        System.out.println( new What3WordsRequest(urlBase,apiKey).RequestW3W(coordinateString) ); 
        System.out.println( new What3WordsRequest(urlBase,apiKey).RequestPosition(w3wString) ); 

    }
}