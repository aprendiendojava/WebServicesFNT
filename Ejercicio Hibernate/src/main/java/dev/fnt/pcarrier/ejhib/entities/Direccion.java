package dev.fnt.pcarrier.ejhib.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Direccion extends GenericEntity {
	private String direccion;
	private String ciudad;
	private String pais;
	private String cp;

	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)
	@OneToOne
	@PrimaryKeyJoinColumn
	private Proveedor proveedor;
}
