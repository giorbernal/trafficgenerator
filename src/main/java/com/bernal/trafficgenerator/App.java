package com.bernal.trafficgenerator;

import java.io.Reader;
import java.util.Random;

import com.bernal.trafficgenerator.iomanager.CsvLine;
import com.bernal.trafficgenerator.iomanager.CsvLine.Item;
import com.bernal.trafficgenerator.iomanager.CsvWriter;
import com.bernal.trafficgenerator.iomanager.JsonReader;
import com.bernal.trafficgenerator.message.Profile;
import com.bernal.trafficgenerator.message.Time;
import com.bernal.trafficgenerator.message.TrafficPattern;
import com.google.gson.Gson;

public class App 
{
	
	private static Random r = new Random();

    public static void main( String[] args )
    {
        System.out.println("Starting traffic generator: generating traffic.csv ... ");
        
    	Gson gson = new Gson();
    	
		try {
			Reader jsonReader = JsonReader.getJsonReader();
	    	TrafficPattern pattern = gson.fromJson(jsonReader, TrafficPattern.class);
	    	pattern.validate();
	    	
			CsvWriter writer = new CsvWriter();
	    	for (Profile profile : pattern.getProfiles()) {
	    		for (int i=0; i<profile.getNumberOfElements(); i++) {
	    			handleElement(profile.getName() + "_" + i, profile, pattern.getTime(), writer);
	    		}
	    	}
	    	writer.close();
		} catch (Throwable e) {
			System.err.println("error in generator process!!");
			e.printStackTrace();
		}
        
        System.out.println("process finished: traffic.csv generated!");
    }
    
    private static void handleElement(String id, Profile profile, Time time, CsvWriter writer) {
    	boolean isOut = false;
    	long lastTimestamp = time.getInit() + (long)(Math.random()*profile.getMean());
    	while (!isOut) {
    		long delay = profile.getMean() + (long)(r.nextGaussian()*profile.getStdev()*(r.nextBoolean()?1:-1));
    		lastTimestamp = lastTimestamp + delay;
    		if (lastTimestamp > time.getEnd()) {
    			isOut = true;
    			continue;
    		}

    		CsvLine line = new CsvLine();
    		line.addItem(Item.ID, id);    		
    		line.addItem(Item.TIMESTAMP, Long.toString(lastTimestamp));
    		line.addItem(Item.MSG_TYPE, profile.getType());
    		line.addItem(Item.ORGANIZATION, profile.getOrganization());
    		line.addItem(Item.MODEL, profile.getType());
    		line.addItem(Item.LOCATION, profile.getLocation());
    		if ((profile.getSessionTime() != null) && profile.getSessionTime().booleanValue())
    			line.addItem(Item.SESSION_TIME, Long.toString(delay));
    		
    		writer.addLine(line);
    	}
    } 
    
}
