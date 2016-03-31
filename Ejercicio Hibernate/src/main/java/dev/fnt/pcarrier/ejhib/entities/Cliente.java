package dev.fnt.pcarrier.ejhib.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends GenericEntity<Cliente> {
	private String nombre;
	private String apellidos;

	@OneToMany(mappedBy="cliente")
	private Set<Pedido> pedidos;
}
