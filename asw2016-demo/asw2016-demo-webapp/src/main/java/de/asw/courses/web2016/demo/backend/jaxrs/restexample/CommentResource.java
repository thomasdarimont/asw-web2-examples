package de.asw.courses.web2016.demo.backend.jaxrs.restexample;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

/**
 * Simple example for a RESTful Resource with JAX-RS.
 * 
 * <p>
 * To create a new comment send a POST request to
 * {@code http://localhost:8080/asw2016-demo-webapp/resources/comment} with the
 * following body:
 * 
 * <pre>
 * {@code 
 *   {
 *   "email": "tom@localhost",
 *   "message": "Hallo Welt"
 *   }
 * }
 * </pre>
 * 
 * The reponse header "Location" will point to the newly created comment.
 * </p>
 * 
 * <p>
 * Send a GET request to the the URI provided in the location response header.
 * E.g.
 * {@code http://localhost:8080/asw2016-demo-webapp/resources/comment/0cc3df3d-67bb-4f7d-8787-8ad347f2d6d3}.
 * Experiment with different "Accept" Request headers, e.g. application/json,
 * application/xml, text/plain
 * </p>
 * 
 * <p>
 * You can get a list of all your created comments by sending a GET request to
 * {@code http://localhost:8080/asw2016-demo-webapp/resources/comment}
 * </p>
 * 
 * @author tom
 */
@Path("/comment")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
public class CommentResource {

	// Injects an implementation of CommentRepository
	@Inject
	private CommentRepository commentRepository;

	// JAX-RS Context Object provided via JAX-RS Runtime
	@Context
	private UriInfo uriInfo;

	/**
	 * Returns a list of comments.
	 * 
	 * @return
	 */
	@GET
	public Response listComments() {
		return Response.ok(commentRepository.findAll()).build();
	}

	/**
	 * Stores a new {@link Comment}.
	 * 
	 * @param comment
	 * @return
	 */
	@POST
	public Response newComment(@Valid Comment comment) {
		Comment saved = commentRepository.save(comment);
		return Response.created(uriInfo.getAbsolutePathBuilder().path(saved.getId()).build()).build();
	}

	/**
	 * Returns the {@link Comment} details for the given {@code commentId}
	 * 
	 * @param commentId the commentId
	 * @return
	 */
	@GET
	@Path("/{commentId}")
	public Response getCommentDetails(@PathParam("commentId") String commentId) {

		Comment comment = commentRepository.findOneById(commentId);
		if (comment == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(comment) //
				.link("http://example.com/services/report_abuse", "abuse") //
				.link("http://example.com/services/spam", "spam") //
				.build();
	}

	/**
	 * Removes the comment for the given {@code commentId}
	 * 
	 * @param commentId
	 * @return
	 */
	@DELETE
	@Path("/{commentId}")
	public Response removeComment(@PathParam("commentId") String commentId) {

		if (commentRepository.deleteById(commentId)) {
			return Response.noContent().build();
		}

		return Response.status(Status.NOT_FOUND).build();
	}
}
