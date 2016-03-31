package dev.fnt.webstorage.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class SimpleRest {
	@GET
	@Path("/test")
	public Response test() {
		System.out.println("ENTRA");
		return Response.ok("TEST").build();
	}

	@POST
	@Path("/suma")
	public Response getSuma( Long suma ) {
		System.out.println(suma);
		System.out.println("SUMA");
		return Response.ok().build();		
	}
}
