package dev.fnt.pcarrier.ejhib.conf;

import java.util.Iterator;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;

public class CustomDeserializerModifier extends BeanDeserializerModifier {

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
				System.out.println("DELEGATEE");
				properties.remove();
				builder.addProperty(property.withValueDeserializer(new CustomDeserializer<>()));
				System.out.println("DELEGATEE2");
			}
		}
	return super.updateBuilder(config, beanDesc, builder);
	}
}
