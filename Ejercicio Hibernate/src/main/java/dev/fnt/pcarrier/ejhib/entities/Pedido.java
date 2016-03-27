package dev.fnt.pcarrier.ejhib.entities;

import java.util.Date;
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
public class Pedido extends GenericEntity {
	private Date fecha;

	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)
	@ManyToMany
	@JoinTable( name = "producto_pedido",
				joinColumns = @JoinColumn( name = "idPedido" ),
				inverseJoinColumns = @JoinColumn( name = "idProducto" ))
	private Set<Producto> productos;
}
