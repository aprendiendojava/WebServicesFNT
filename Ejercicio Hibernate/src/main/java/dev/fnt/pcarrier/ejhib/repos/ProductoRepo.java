package dev.fnt.pcarrier.ejhib.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.pcarrier.ejhib.entities.Producto;

public interface ProductoRepo extends PagingAndSortingRepository<Producto, Long> {}
