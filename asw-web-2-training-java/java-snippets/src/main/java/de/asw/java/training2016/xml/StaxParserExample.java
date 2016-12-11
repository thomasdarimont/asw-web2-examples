package de.asw.java.training2016.xml;

import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class StaxParserExample {

	public static void main(String[] args) throws Exception {

		InputStream is = SaxParserExample.class.getClassLoader() //
				.getResourceAsStream("messages.xml");
		XMLStreamReader reader = XMLInputFactory.newFactory() //
				.createXMLStreamReader(is);

		while (reader.hasNext()) {
			switch (reader.next()) {
			case XMLStreamReader.CHARACTERS:
				System.out.println(reader.getText());
				break;
			case XMLStreamReader.START_ELEMENT:
				System.out.println("Start Element: " + reader.getName());
				break;
			}
		}
	}
}
