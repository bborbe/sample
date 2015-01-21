package example.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/post")
public class PostRestService {

	public static final String PARAMETER_VERGLEICHER = "param";

	private static final Logger logger = LoggerFactory.getLogger(PostRestService.class);

	@Inject
	public PostRestService() {
	}

	@POST
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postOnlyXML(@QueryParam(PARAMETER_VERGLEICHER) final String param, final String data) {
		logger.debug("param: {} data: {}", param, data);
		return Response.ok().build();
	}

}
