package com.bernal.trafficgenerator;

import java.io.Reader;
import java.util.Arrays;

import com.bernal.trafficgenerator.iomanager.JsonReader;
import com.bernal.trafficgenerator.message.Profile;
import com.bernal.trafficgenerator.message.Time;
import com.bernal.trafficgenerator.message.TrafficPattern;
import com.google.gson.Gson;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ConverterTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ConverterTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ConverterTest.class );
    }

    /**
     * From Object to File Test :-)
     * @throws Throwable 
     */
    public void testFromObjectToJson() throws Throwable
    {
    	Profile profile = new Profile();
    	profile.setName("test1");
    	profile.setOrganization("test_org");
    	profile.setModel("Naomi");
    	profile.setLocation("Madrid");
    	profile.setType("ACC");
    	profile.setMean(86400l);
    	profile.setStdev(1500l);
    	
    	// 1 semana
    	Time time = new Time();
    	time.setInit(1450540333l);
    	time.setEnd(1451145133l);
    	
    	TrafficPattern pattern = new TrafficPattern();
    	pattern.setOrganizations(Arrays.asList(new String[]{"base_org","test_org"}));
    	pattern.setModels(Arrays.asList(new String[]{"Naomi","Claudia"}));
    	pattern.setMsgTypes(Arrays.asList(new String[]{"ACC","RESP","DATA"}));
    	pattern.setTime(time);
    	pattern.setProfiles(Arrays.asList(new Profile[]{profile}));

    	pattern.validate();
    	
    	Gson gson = new Gson();
    	String patternStr = gson.toJson(pattern);
    	
    	System.out.println(patternStr);

    	Assert.assertEquals("{\"organizations\":[\"base_org\",\"test_org\"],\"msgTypes\":[\"ACC\",\"RESP\",\"DATA\"],\"models\":[\"Naomi\",\"Claudia\"],\"time\":{\"init\":1450540333,\"end\":1451145133},\"profiles\":[{\"name\":\"test1\",\"type\":\"ACC\",\"organization\":\"test_org\",\"model\":\"Naomi\",\"location\":\"Madrid\",\"mean\":86400,\"stdev\":1500}]}", patternStr);
    }
    
    /**
     * From File to Object Test :-)
     * @throws Throwable 
     */
    public void testFromJsonToObject() throws Throwable
    {
   	
    	Gson gson = new Gson();
    	
    	Reader jsonReader = JsonReader.getJsonReader();
    	TrafficPattern pattern = gson.fromJson(jsonReader, TrafficPattern.class);
    	pattern.validate();
    	
    	Assert.assertEquals(3, pattern.getProfiles().size());
    }

    
    
}
