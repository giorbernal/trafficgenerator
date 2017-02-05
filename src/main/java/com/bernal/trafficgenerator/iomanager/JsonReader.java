package com.bernal.trafficgenerator.iomanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonReader {
	
	private static String CONFIG_FOLDER = "profiles-conf";
	private static String FILE_NAME = "profiles.json";
	
	public static Reader getJsonReader() throws Throwable {

		try {
			String filePath = System.getProperty("user.dir") + "/" + CONFIG_FOLDER + "/" + FILE_NAME;
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			return br;
		} catch (IOException e) {
			throw new Throwable(e);
		}

	}

}
