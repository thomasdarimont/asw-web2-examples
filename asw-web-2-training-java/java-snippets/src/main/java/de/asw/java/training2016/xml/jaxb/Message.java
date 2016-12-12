package de.asw.java.training2016.xml.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message")
public class Message {

	@XmlAttribute(name = "id")
	String id;

	String to;

	String from;

	String heading;

	String body;

	@Override
	public String toString() {
		return "Message [id=" + id + ", to=" + to + ", from=" + from + ", heading=" + heading + ", body=" + body + "]";
	}
}