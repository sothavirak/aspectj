package edu.sample.cxf;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@JsonApiResourceRepository(CustomerDto.class)
@Path("/hello")
public class HelloService {
	
	@GET
	@Path("/say")
	public String saySomething() {
		return "Hello Service";
	}
}
