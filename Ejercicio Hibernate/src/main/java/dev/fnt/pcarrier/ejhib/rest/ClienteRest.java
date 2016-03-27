package dev.fnt.pcarrier.ejhib.rest;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import dev.fnt.pcarrier.ejhib.entities.Cliente;
import dev.fnt.pcarrier.ejhib.repos.ClienteRepo;

@Component
@Path("/cliente")
public class ClienteRest extends GenericRest<Cliente> {
	@Autowired private ClienteRepo repo;
	@Override
	protected PagingAndSortingRepository<Cliente, Long> getRepo() {
		return repo;
	}}
