package dev.fnt.pcarrier.ejhib.rest;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import dev.fnt.pcarrier.ejhib.entities.Pedido;
import dev.fnt.pcarrier.ejhib.repos.PedidoRepo;

@Component
@Path("/pedido")
public class PedidoRest extends GenericRest<Pedido> {
	@Autowired private PedidoRepo repo;
	@Override
	protected PagingAndSortingRepository<Pedido, Long> getRepo() {
		return repo;
	}}
