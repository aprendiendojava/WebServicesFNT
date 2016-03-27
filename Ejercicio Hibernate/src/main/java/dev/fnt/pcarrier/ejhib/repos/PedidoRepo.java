package dev.fnt.pcarrier.ejhib.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.pcarrier.ejhib.entities.Pedido;

public interface PedidoRepo extends PagingAndSortingRepository<Pedido, Long> {}
