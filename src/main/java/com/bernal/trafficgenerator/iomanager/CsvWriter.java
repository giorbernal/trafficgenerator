package com.bernal.trafficgenerator.iomanager;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CsvWriter {
	
	private String CSV_FILENAME = "traffic.csv";
	private String SEP = ";";

	private PrintWriter writer;
	
	public CsvWriter() throws FileNotFoundException, UnsupportedEncodingException {
		this.writer = new PrintWriter(CSV_FILENAME, "UTF-8");
		this.writer.println(CsvLine.getHeader(SEP));
	}
	
	public void addLine(CsvLine line) {
		this.writer.println(line.getLine(SEP));
	}
	
	public void close() {
		this.writer.close();
	}

}
