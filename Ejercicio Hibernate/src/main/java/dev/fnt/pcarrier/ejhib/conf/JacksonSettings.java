package dev.fnt.pcarrier.ejhib.conf;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Provider
public class JacksonSettings implements ContextResolver<ObjectMapper> {
	private final ObjectMapper om = new ObjectMapper()
			.setVisibility( PropertyAccessor.FIELD		, Visibility.ANY )
			.setVisibility( PropertyAccessor.CREATOR	, Visibility.NONE )
			.setVisibility( PropertyAccessor.GETTER		, Visibility.NONE )
			.setVisibility( PropertyAccessor.IS_GETTER	, Visibility.NONE )
			.setVisibility( PropertyAccessor.SETTER		, Visibility.NONE )
			.registerModule(new SimpleModule().setDeserializerModifier(new CustomDeserializerModifier()))
			.setFilterProvider(new SimpleFilterProvider().addFilter("CustomFilter", new CustomFilter()));

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return om;
	}
}