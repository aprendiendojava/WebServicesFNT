package dev.fnt.pcarrier.ejhib.conf;

import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;

public class CustomDeserializerModifier extends BeanDeserializerModifier {

//	@Override
//	public BeanDeserializerBuilder updateBuilder(DeserializationConfig config, BeanDescription beanDesc,
//			BeanDeserializerBuilder builder) {
//		builder.addIgnorable("nombre");
//		builder.removeProperty(new PropertyName("nombre"));
//		return super.updateBuilder(config, beanDesc, builder);
//	}
}
