package dev.fnt.pcarrier.ejhib.conf;

import java.util.Iterator;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;

@Component
public class CustomDeserializerModifier extends BeanDeserializerModifier {
	@Autowired
	private RelationDeserializer<?> relDeserializer;

	@Override
	public BeanDeserializerBuilder updateBuilder(DeserializationConfig config, BeanDescription beanDesc,
		BeanDeserializerBuilder builder) {

		SettableBeanProperty property;
		Iterator<SettableBeanProperty> properties = builder.getProperties();
		while( properties.hasNext()) {
			property = properties.next();
			System.out.println(property.getName());
			if( property.getAnnotation(ManyToMany.class) != null
				|| property.getAnnotation(OneToMany.class) != null
				|| property.getAnnotation(ManyToOne.class) != null )
			{
				properties.remove();
				property.getType().getContentType();
				System.out.println(property.getType().getContentType().getRawClass());
				relDeserializer.setType(property.getType().getContentType());
				builder.addProperty(property.withValueDeserializer(relDeserializer));
			}
		}
	return super.updateBuilder(config, beanDesc, builder);
	}
}
