package dev.fnt.pcarrier.ejhib.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends GenericEntity<Cliente> {
	private String nombre;
	private String apellidos;

	@OneToMany(mappedBy="cliente",cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE})
	private Set<Pedido> pedidos;
}
