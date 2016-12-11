package de.asw.courses.aswweb2.demo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.Data;

@Data
@Named
@SessionScoped
public class Calculator implements Serializable {

	BigDecimal value1; // getter / setter
	BigDecimal value2; // getter / setter
	BigDecimal result; // getter / setter
	String op; // getter / setter

	public void calculate() {
		if (op == null) { return; }
		switch (op) {
		case "plus": result = value1.add(value2); break;
		case "minus": result = value1.subtract(value2); break;
		// Add some additional operations here
		}
	}
}
