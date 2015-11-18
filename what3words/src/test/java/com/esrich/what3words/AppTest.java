package com.esrich.what3words;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	private static String coordinateString = "-26.385267,153.087262";
	private static String expectedResponse_coordinateString = "{\"words\":[\"bond\",\"eardrum\",\"expose\"],\"position\":[-26.385255,153.087262],\"language\":\"en\"}";
	private static String w3wString = "chipper.enchanted.slops";
	private static String expectedResponse_w3wString = "{\"type\":\"3 words\",\"words\":[\"chipper\",\"enchanted\",\"slops\"],\"position\":[-26.385471,153.087804],\"language\":\"en\"}";
	
	private static String urlBase = "https://api.what3words.com/";
	private static String apiKey = "";
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testW3WRequest()
    {
    	String responseString = new What3WordsRequest(urlBase,apiKey).RequestW3W(coordinateString);
        assertNotNull("The Response is Null", responseString);
        
        assertEquals(expectedResponse_coordinateString, responseString);
    	
    }
    
    
    public void testPositionRequest()
    {
    	String responseString = new What3WordsRequest(urlBase,apiKey).RequestPosition(w3wString);
        assertNotNull("The Response is Null", responseString);
        
        assertEquals(expectedResponse_w3wString, responseString);
    }

    public void testJsonSimpleDeserialise() throws ParseException
    {

        JSONObject json = (JSONObject)new JSONParser().parse("{\"name\":\"MyNode\", \"width\":200, \"height\":100}");
        System.out.println("name=" + json.get("name"));
        System.out.println("width=" + json.get("width"));
        
    }
    
}
