package com.bernal.trafficgenerator.iomanager;

import java.util.Hashtable;

public class CsvLine {
	
	public enum Item {
		ID,
		TIMESTAMP,
		MSG_TYPE,
		ORGANIZATION,
		MODEL,
		LOCATION,
		SESSION_TIME
	}
	
	private Hashtable<Item, String> line;

	public CsvLine() {
		line = new Hashtable<CsvLine.Item, String>();
	}

	public void addItem(Item item, String param) {
		line.put(item, param);
	}
	
	public String getLine(String sep) {
		Item[] items = Item.values();
		StringBuilder b = new StringBuilder();
		int cont = 0;
		for (Item item : items) {
			b.append(line.get(item));
			cont++;
			if (cont < items.length)
				b.append(sep);
		}
		return b.toString();
	}
	
	public static String getHeader(String sep) {
		Item[] items = Item.values();
		StringBuilder b = new StringBuilder();
		int cont = 0;
		for (Item item : items) {
			b.append(item);
			cont++;
			if (cont < items.length)
				b.append(sep);
		}
		return b.toString();
	}

}
