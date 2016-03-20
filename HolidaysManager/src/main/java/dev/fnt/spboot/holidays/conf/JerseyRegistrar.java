package dev.fnt.spboot.holidays.conf;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import dev.fnt.spboot.holidays.rest.EmployeeRest;

@Component
public class JerseyRegistrar extends ResourceConfig {
	public JerseyRegistrar() {
		register(EmployeeRest.class);
		register(JacksonSettings.class);
	}
}
