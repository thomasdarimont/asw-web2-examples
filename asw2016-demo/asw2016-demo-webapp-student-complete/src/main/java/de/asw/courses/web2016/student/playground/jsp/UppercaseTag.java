package de.asw.courses.web2016.student.playground.jsp;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class UppercaseTag extends BodyTagSupport {

	public int doAfterBody() throws JspException {
		try {
			// Writer für die Ausgabe
			JspWriter out = bodyContent.getEnclosingWriter();
			out.println("Ausgabe:");
			// Ausgabe des Body
			BodyContent bodyContent = super.getBodyContent();
			String bodyString = bodyContent.getString();

			 out.print(bodyString.toUpperCase());
			 bodyContent.clear();
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		
		return SKIP_BODY;
	}
}