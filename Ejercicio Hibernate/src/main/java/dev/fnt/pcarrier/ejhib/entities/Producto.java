package dev.fnt.pcarrier.ejhib.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Producto extends GenericEntity<Producto> {
	private String nombre;
	private Float precio;
	private String moneda;

	@ManyToOne
	@JoinColumn(name="idProveedor")
	private Proveedor proveedor;

	@ManyToMany
	@JoinTable( name = "producto_pedido",
				joinColumns = @JoinColumn( name = "idProducto" ),
				inverseJoinColumns = @JoinColumn( name = "idPedido" ))
	private Set<Pedido> pedidos;
}
