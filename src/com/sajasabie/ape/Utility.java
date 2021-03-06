package com.sajasabie.ape;

public class Utility {
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	}
	public static double direction(double x1, double y1, double x2, double y2) {
		return Math.atan2(y2-y1, x2-x1);
	}
}
