package com.gamerz.utils;

public class GameUtils {

	public static double[] angleToVector(double ang) {
		return new double[] { Math.cos(ang), Math.sin(ang) };
	}
}
