package de.asw.courses.web2016.demo.backend.jaxrs.restexample;

import java.util.List;

public interface CommentRepository {

	Comment save(Comment comment);
	
	Comment findOneById(String id);
	
	List<Comment> findAll();
	
	boolean deleteById(String id);
}
