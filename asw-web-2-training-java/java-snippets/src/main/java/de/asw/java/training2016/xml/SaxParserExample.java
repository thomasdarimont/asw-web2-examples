package de.asw.java.training2016.xml;

import java.io.InputStream;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserExample {

	public static void main(String[] args) throws Exception {

		InputStream is = SaxParserExample.class.getClassLoader() //
				.getResourceAsStream("messages.xml");
		DefaultHandler dh = new DefaultHandler() {
			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				System.out.println("Start Element: " + qName);
			}
		};
		SAXParserFactory //
				.newInstance() //
				.newSAXParser() //
				.parse(is, dh);
	}
}
