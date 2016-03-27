package dev.fnt.pcarrier.ejhib.rest;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import dev.fnt.pcarrier.ejhib.entities.Direccion;
import dev.fnt.pcarrier.ejhib.repos.DireccionRepo;

@Component
@Path("/direccion")
public class DireccionRest extends GenericRest<Direccion> {
	@Autowired private DireccionRepo repo;
	@Override
	protected PagingAndSortingRepository<Direccion, Long> getRepo() {
		return repo;
	}}
