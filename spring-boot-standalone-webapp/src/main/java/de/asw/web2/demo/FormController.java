package de.asw.web2.demo;

import java.util.List;
import java.util.Map;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FormController {

	/**
	 * {@code curl -v -d "foo=1&bar=2" http://localhost:8080/form }
	 * 
	 * @param formData
	 * @return
	 */
	@RequestMapping(path = "/form", method = RequestMethod.POST)
	String processFormData(@RequestBody MultiValueMap<String, String> formData) {

		System.out.printf("Form Data: %s%n", formData);
		for (Map.Entry<String, List<String>> entry : formData.entrySet()) {
			System.out.printf("%s: %s%n", entry.getKey(), entry.getValue());
		}

		return "Form data processing complete!";
	}
}
