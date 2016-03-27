package dev.fnt.pcarrier.ejhib.conf;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import dev.fnt.pcarrier.ejhib.rest.ClienteRest;
import dev.fnt.pcarrier.ejhib.rest.DireccionRest;
import dev.fnt.pcarrier.ejhib.rest.PedidoRest;
import dev.fnt.pcarrier.ejhib.rest.ProductoRest;
import dev.fnt.pcarrier.ejhib.rest.ProveedorRest;

@Component
public class JerseyRegistrar extends ResourceConfig {
	public JerseyRegistrar() {
		register(ClienteRest.class);
		register(DireccionRest.class);
		register(PedidoRest.class);
		register(ProductoRest.class);
		register(ProveedorRest.class);
		register(JacksonSettings.class);
	}
}
