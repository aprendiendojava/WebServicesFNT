package dev.fnt.pcarrier.ejhib.conf;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Provider
public class JacksonSettings implements ContextResolver<ObjectMapper> {
	@Autowired
	private CustomDeserializerModifier deserializerModifier;
	@Autowired
	private CustomFilter customFilter;

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return new ObjectMapper()
		.setVisibility( PropertyAccessor.FIELD		, Visibility.ANY )
		.setVisibility( PropertyAccessor.CREATOR	, Visibility.NONE )
		.setVisibility( PropertyAccessor.GETTER		, Visibility.NONE )
		.setVisibility( PropertyAccessor.IS_GETTER	, Visibility.NONE )
		.setVisibility( PropertyAccessor.SETTER		, Visibility.NONE )
		.registerModule(new SimpleModule().setDeserializerModifier(deserializerModifier))
		.setFilterProvider(new SimpleFilterProvider().addFilter("CustomFilter", customFilter));
	}
}