package dev.fnt.pcarrier.ejhib.rest;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import dev.fnt.pcarrier.ejhib.entities.Proveedor;
import dev.fnt.pcarrier.ejhib.repos.ProveedorRepo;

@Component
@Path("/proveedor")
public class ProveedorRest extends GenericRest<Proveedor> {
	@Autowired private ProveedorRepo repo;
	@Override
	protected PagingAndSortingRepository<Proveedor, Long> getRepo() {
		return repo;
	}}
