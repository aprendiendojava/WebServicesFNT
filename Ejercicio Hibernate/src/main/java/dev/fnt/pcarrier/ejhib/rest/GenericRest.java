package dev.fnt.pcarrier.ejhib.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.pcarrier.ejhib.entities.GenericEntity;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class GenericRest<T extends GenericEntity> {
	protected abstract PagingAndSortingRepository<T, Long> getRepo();

	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") Long id) {
		T found = getRepo().findOne(id);
		if(found!=null)
			return Response.ok(getRepo().findOne(id)).build();
		else return Response.noContent().build();
	}

	@GET
	@Path("/all")
	public Response findAll() {
		return Response.ok(getRepo().findAll()).build();
	}

	@POST
	@Path("/new")
	public Response save( T entity ) throws URISyntaxException {
		String curPath = this.getClass().getAnnotation(Path.class).value();
		T created = getRepo().save(entity);
		return Response.created(new URI(curPath+"/"+created.getId())).entity(created).build();
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") Long id, T entity) {
		if( entity.getId() != id || !getRepo().exists(id))
			return Response.notModified().build();
		else{
			return Response.accepted(getRepo().save(entity)).build();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		getRepo().delete(id);
		return Response.ok().build();
	}

	@DELETE
	@Path("/all")
	public Response deleteAll() {
		getRepo().deleteAll();
		return Response.ok().build();
	}
}
