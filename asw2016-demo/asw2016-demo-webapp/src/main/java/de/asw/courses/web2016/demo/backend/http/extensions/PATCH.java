package de.asw.courses.web2016.demo.backend.http.extensions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.NameBinding;

/**
 * @author tom
 *
 * @see https://dzone.com/articles/transparent-patch-support-jax
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@HttpMethod("PATCH")
@Documented
@NameBinding
public @interface PATCH {
}