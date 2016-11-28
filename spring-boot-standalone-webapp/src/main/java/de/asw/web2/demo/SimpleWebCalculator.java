package de.asw.web2.demo;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SimpleWebCalculator {

	/**
	 * List's available operations.
	 * 
	 * {@code curl http://localhost:8080/calc/ops }
	 * 
	 * @param formData
	 * @return
	 */
	@GetMapping("/calc/ops")
	List<String> listSupportedOperations() {
		return asList("add:(x + y)", "subtract:(x - y)", "multiply:(x * y)", "divide:(x / y)", "pow:(x ^ y)");
	}

	/**
	 * Computes the result for the given operations and operands.
	 * 
	 * {@code curl -d "x=2&y=10&op=pow" http://localhost:8080/calc }
	 * 
	 * @see #listSupportedOperations() for the list of supported op-codes.
	 * @param formData
	 * @return
	 */
	@PostMapping("/calc")
	ResponseEntity<String> calc(@RequestBody MultiValueMap<String, String> formData) {

		Object result;
		try {

			BigDecimal x = new BigDecimal(formData.getFirst("x"));
			BigDecimal y = new BigDecimal(formData.getFirst("y"));
			String op = formData.getFirst("op");

			switch (op) {
			case "add":
				result = x.add(y);
				break;
			case "subtract":
				result = x.subtract(y);
				break;
			case "multiply":
				result = x.multiply(y);
				break;
			case "divide":
				result = x.divide(y);
				break;
			case "pow":
				result = x.pow(y.intValue());
				break;
			default:
				return ResponseEntity.badRequest().body("Error: don't know how to: " + op);
			}

		} catch (NumberFormatException nfe) {
			return ResponseEntity.badRequest().body(nfe.toString());
		}

		return ResponseEntity.ok(result.toString());
	}
}
