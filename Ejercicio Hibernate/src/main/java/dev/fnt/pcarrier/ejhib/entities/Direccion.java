package dev.fnt.pcarrier.ejhib.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Direccion extends GenericEntity {
	private String direccion;
	private String ciudad;
	private String pais;
	private String cp;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Proveedor proveedor;
}
