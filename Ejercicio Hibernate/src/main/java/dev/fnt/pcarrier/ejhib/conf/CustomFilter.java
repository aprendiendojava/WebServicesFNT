package dev.fnt.pcarrier.ejhib.conf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

import dev.fnt.pcarrier.ejhib.entities.GenericEntity;

@Component
public class CustomFilter extends SimpleBeanPropertyFilter {
	@Override
	public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
			throws Exception {
		if
		(  writer.findAnnotation(OneToMany.class)	!= null
		|| writer.findAnnotation(ManyToMany.class)	!= null )
		{
			serializeAnyToMany(pojo, jgen, provider, writer);
		}
		else if( writer.findAnnotation(ManyToOne.class)	!= null )
		{
			serializeManyToOne(pojo, jgen, provider, writer);
		}
		else
			super.serializeAsField(pojo, jgen, provider, writer);
	}

	private void serializeAnyToMany(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws IOException {
		jgen.writeFieldName(writer.getName());
		jgen.writeStartArray();

		Collection<?> c = (Collection<?>)getCurrentProperty(pojo,writer.getName());
		for(Object relation:c) {
			GenericEntity entity = (GenericEntity)relation;
			jgen.writeNumber(entity.getId());
		}

		jgen.writeEndArray();
	}

	private void serializeManyToOne(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws IOException {
		jgen.writeFieldName(writer.getName());
		GenericEntity entity = (GenericEntity)getCurrentProperty(pojo,writer.getName());
		jgen.writeNumber(entity.getId());
	}

	private Object getCurrentProperty(Object pojo, String propertyName) {
		Field relation;
		try {
			relation = pojo.getClass().getDeclaredField(propertyName);
			relation.setAccessible(true);
			return relation.get(pojo);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}
}
