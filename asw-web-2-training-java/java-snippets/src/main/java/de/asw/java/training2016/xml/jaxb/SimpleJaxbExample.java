package de.asw.java.training2016.xml.jaxb;

import java.io.InputStream;

import javax.xml.bind.JAXB;

import de.asw.java.training2016.xml.SaxParserExample;

public class SimpleJaxbExample {
	public static void main(String[] args) {

		InputStream is = SaxParserExample.class//
				.getClassLoader() //
				.getResourceAsStream("message.xml");

		// Convert XML to Java Object
		Message message = JAXB.unmarshal(is, Message.class);
		System.out.println(message);

		// Convert Java Object to XML
		JAXB.marshal(message, System.out);
	}
}
