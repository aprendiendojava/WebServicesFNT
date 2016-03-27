package dev.fnt.pcarrier.ejhib.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.pcarrier.ejhib.entities.Cliente;

public interface ClienteRepo extends PagingAndSortingRepository<Cliente, Long> {}
