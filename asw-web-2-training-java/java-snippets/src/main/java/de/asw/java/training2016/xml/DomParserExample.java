package de.asw.java.training2016.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParserExample {

	public static void main(String[] args) throws Exception {

		InputStream is = SaxParserExample.class.getClassLoader() //
				.getResourceAsStream("message.xml");

		DocumentBuilder parser = DocumentBuilderFactory //
				.newInstance() //
				.newDocumentBuilder();

		Document document = parser.parse(is);

		NodeList nodeList = document.getElementsByTagName("message");
		for (int i = 0, len = nodeList.getLength(); i < len; i++) {
			Node node = nodeList.item(i);
			System.out.printf("%s id=%s%n", //
					node.getNodeName(), //
					node.getAttributes().getNamedItem("id").getNodeValue());
		}
	}
}
