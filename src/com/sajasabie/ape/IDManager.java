package com.sajasabie.ape;

public class IDManager {
	private static int nextID = 100;
	
	public static int getNextID() {
		return nextID++;
	}
}
