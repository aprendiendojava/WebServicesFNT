package dev.fnt.pcarrier.ejhib.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Proveedor extends GenericEntity {
	private String nombre;

	@JsonIgnoreProperties({"proveedor" })
	@OneToOne(mappedBy="proveedor")
	private Direccion direccion;

	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)
	@OneToMany(mappedBy="proveedor")
	private Set<Producto> productos;
}
