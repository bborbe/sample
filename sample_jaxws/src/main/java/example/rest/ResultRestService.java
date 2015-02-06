package example.rest;

import example.Result;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/results")
public class ResultRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		final List<Result> list = Arrays.asList(
			createResult("foo1", "test1", true), createResult("foo1", "test2", false), createResult("foo1", "test3", true),
			createResult("foo1", "test1", true), createResult("foo1", "test2", true), createResult("foo1", "test3", null),
			createResult("foo3", "test1", true), createResult("foo3", "test2", true), createResult("foo3", "test3", false)
		);

		final ObjectMapper mapper = new ObjectMapper();
		return Response.ok(mapper.valueToTree(list).toString()).build();
	}

	private Result createResult(final String foo, final String name, final Boolean success) {
		final Result result = new Result();
		result.setName(name);
		result.setSuccess(success);
		result.setDescription(foo);
		return result;
	}
}
