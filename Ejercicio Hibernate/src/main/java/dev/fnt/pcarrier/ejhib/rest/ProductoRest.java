package dev.fnt.pcarrier.ejhib.rest;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import dev.fnt.pcarrier.ejhib.entities.Producto;
import dev.fnt.pcarrier.ejhib.repos.ProductoRepo;

@Component
@Path("/producto")
public class ProductoRest extends GenericRest<Producto> {
	@Autowired private ProductoRepo repo;
	@Override
	protected PagingAndSortingRepository<Producto, Long> getRepo() {
		return repo;
	}}
