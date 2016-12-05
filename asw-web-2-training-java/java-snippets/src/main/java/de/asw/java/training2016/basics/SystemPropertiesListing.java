package de.asw.java.training2016.basics;

import java.util.Map;

public class SystemPropertiesListing {

	public static void main(String[] args) {

		System.out.println("Key Value");
		for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
