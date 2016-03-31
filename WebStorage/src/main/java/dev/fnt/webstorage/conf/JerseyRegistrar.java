package dev.fnt.webstorage.conf;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import dev.fnt.webstorage.rest.SimpleRest;

@Configuration
@ApplicationPath("/rest")
public class JerseyRegistrar extends ResourceConfig {
	public JerseyRegistrar() {
		System.out.println("REGISTRAR");
		register(SimpleRest.class);
	}
}
