package de.asw.java.training2016.lang;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

// Verwendung
@Example("Annotations")
public class AnnotationsExample {
}

// Definition
@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@interface Example {
	String value() default "Beispiel";
}

@AnTyp
class Typ {

	@AnField
	String field;

	@AnConstructor
	public Typ(@AnParameter String param) {
	}

	public Typ(List<@AnGenericTypeParameter String> params) {
	}

	@AnMethod
	public void methode() {

	}
}

@Target(ElementType.TYPE)
@interface AnTyp {
}

@Target(ElementType.CONSTRUCTOR)
@interface AnConstructor {
}

@Target(ElementType.FIELD)
@interface AnField {
}

@Target(ElementType.METHOD)
@interface AnMethod {
}

@Target(ElementType.PARAMETER)
@interface AnParameter {
}

@Target(ElementType.TYPE_USE) // Seit Java 8
@interface AnGenericTypeParameter {
}

@AnAnnotation
@Target(ElementType.ANNOTATION_TYPE)
@interface AnAnnotation {
}

@interface AnAll {	
}