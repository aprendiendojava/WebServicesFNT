package dev.fnt.pcarrier.ejhib.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pedido extends GenericEntity<Pedido> {
	private Date fecha;

	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE})
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	@ManyToMany
	@JoinTable( name = "producto_pedido",
				joinColumns = @JoinColumn( name = "idPedido" ),
				inverseJoinColumns = @JoinColumn( name = "idProducto" ))
	private Set<Producto> productos;
}
