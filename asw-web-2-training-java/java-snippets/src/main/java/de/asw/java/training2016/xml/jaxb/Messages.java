package de.asw.java.training2016.xml.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messages")
@XmlAccessorType(XmlAccessType.FIELD)
public class Messages {
	
	@XmlElement(name = "message")
	private List<Message> messages;

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> employees) {
		this.messages = employees;
	}
}