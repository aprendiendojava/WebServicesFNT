package dev.fnt.pcarrier.ejhib.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Producto extends GenericEntity {
	private String nombre;
	private Float precio;
	private String moneda;

	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private Proveedor proveedor;

	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)
	@ManyToMany
	@JoinTable( name = "producto_pedido",
				joinColumns = @JoinColumn( name = "idProducto" ),
				inverseJoinColumns = @JoinColumn( name = "idPedido" ))
	private Set<Pedido> pedidos;
}
