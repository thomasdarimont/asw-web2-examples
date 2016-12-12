package de.asw.courses.web2016.demo.backend.jaxrs.restexample;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(FIELD)
public class Comment {

	@XmlAttribute(name = "id")
	String id;

	@Email
	String email;

	@NotEmpty
	String message;

	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	LocalDateTime createDate;
}
