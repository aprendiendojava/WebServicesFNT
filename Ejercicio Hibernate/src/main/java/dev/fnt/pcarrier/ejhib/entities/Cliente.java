package dev.fnt.pcarrier.ejhib.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Cliente extends GenericEntity {
	private String nombre;
	private String apellidos;

	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)
	@OneToMany(mappedBy="cliente")
	private Set<Pedido> pedidos;
}
