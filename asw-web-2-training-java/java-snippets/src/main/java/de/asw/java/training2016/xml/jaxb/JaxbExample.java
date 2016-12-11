package de.asw.java.training2016.xml.jaxb;

import java.io.InputStream;

import javax.xml.bind.JAXB;

import de.asw.java.training2016.xml.SaxParserExample;

public class JaxbExample {

	public static void main(String[] args) {

		InputStream is = SaxParserExample.class.getClassLoader() //
				.getResourceAsStream("messages.xml");
		
		System.out.println("Read from XML");
		Messages messages = JAXB.unmarshal(is, Messages.class);
		for (Message msg : messages.getMessages()) {
			System.out.println(msg);
		}
		System.out.println();
		System.out.println("Write to XML");
		JAXB.marshal(messages, System.out);
	}
}
