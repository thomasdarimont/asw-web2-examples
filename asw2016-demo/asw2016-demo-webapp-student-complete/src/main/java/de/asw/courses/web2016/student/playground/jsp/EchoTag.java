package de.asw.courses.web2016.student.playground.jsp;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EchoTag extends SimpleTagSupport {

	public void doTag() throws JspException {
		try {
			// Writer für die Ausgabe
			JspWriter out = getJspContext().getOut();
			out.println("Echo:");
			// Ausgabe des Body
			JspFragment f = getJspBody();
			if (f != null) {
				f.invoke(out);
			}
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
	}
}