package dev.fnt.spboot.holidays.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.fnt.spboot.holidays.persist.ent.Employee;
import dev.fnt.spboot.holidays.persist.repo.EmployeeRepo;

@Component
@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeRest {
	@Autowired
	private EmployeeRepo repo;

	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") Long id ) {
		return Response.ok(repo.findOne(id)).build();
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") Long id, Employee e ) {
		if( id != e.getId()) return Response.notModified().build();
		else return Response.accepted(repo.save(e)).build();
	}

	@POST
	@Path("/search")
	public Response like(Employee e) {
		return Response.ok(repo.like(e)).build();
	}

	@POST
	public Response save(Employee e) throws Exception {
		return Response.ok(repo.save(e)).build();
	}
}
