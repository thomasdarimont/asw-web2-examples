package de.asw.courses.web2016.demo.backend.jaxrs.restexample;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class InMemoryCommentRepository implements CommentRepository {

	private final Map<String, Comment> commentStore = new HashMap<>();

	public Comment save(Comment comment) {

		String id = UUID.randomUUID().toString();
		comment.setId(id);
		comment.setCreateDate(LocalDateTime.now());
		commentStore.put(id, comment);

		return comment;
	}

	@Override
	public Comment findOneById(String id) {
		return commentStore.get(id);
	}

	@Override
	public List<Comment> findAll() {
		return new ArrayList<>(commentStore.values());
	}

	@Override
	public boolean deleteById(String id) {

		Comment removed = commentStore.remove(id);
		return removed != null;
	}
}
