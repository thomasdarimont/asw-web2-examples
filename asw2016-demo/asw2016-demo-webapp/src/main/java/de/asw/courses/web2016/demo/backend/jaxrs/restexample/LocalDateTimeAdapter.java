package de.asw.courses.web2016.demo.backend.jaxrs.restexample;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

	public LocalDateTime unmarshal(String input) throws Exception {
		return LocalDateTime.parse(input);
	}

	public String marshal(LocalDateTime localDateTime) throws Exception {
		return localDateTime.toString();
	}
}