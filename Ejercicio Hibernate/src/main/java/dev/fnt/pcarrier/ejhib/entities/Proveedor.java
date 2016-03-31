package dev.fnt.pcarrier.ejhib.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Proveedor extends GenericEntity<Proveedor> {
	private String nombre;

	@JsonIgnoreProperties({"proveedor" })
	@OneToOne(mappedBy="proveedor")
	private Direccion direccion;

	@OneToMany(mappedBy="proveedor")
	private Set<Producto> productos;
}
