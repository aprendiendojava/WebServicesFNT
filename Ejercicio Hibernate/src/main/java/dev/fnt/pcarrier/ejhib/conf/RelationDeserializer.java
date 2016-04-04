package dev.fnt.pcarrier.ejhib.conf;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;

import dev.fnt.pcarrier.ejhib.entities.GenericEntity;
import dev.fnt.pcarrier.ejhib.entities.Pedido;
import dev.fnt.pcarrier.ejhib.repos.PedidoRepo;

@Component
public class RelationDeserializer<T extends GenericEntity<T>> extends JsonDeserializer<Set<T>> {
	private PagingAndSortingRepository<?, Long> currentRepo;
	@Autowired
	private PedidoRepo pedidos;

	public void setType( JavaType javaType ) {
		if ( javaType.getRawClass().equals(Pedido.class))
			currentRepo = pedidos;
	}

	@Override
	public Set<T> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		Set<T> c = new HashSet<>();

		for( JsonToken jt =  p.nextToken() ; jt != null; jt = p.nextToken()) {
			if( jt.isNumeric())
				c.add((T)currentRepo.findOne(p.getLongValue()));
		}
		
		return c;
	}
}
