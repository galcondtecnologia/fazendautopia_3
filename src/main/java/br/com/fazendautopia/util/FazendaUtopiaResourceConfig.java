package br.com.fazendautopia.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

// http:
@ApplicationPath("rest")
public class FazendaUtopiaResourceConfig extends ResourceConfig {
	public FazendaUtopiaResourceConfig() {
		packages("br.com.fazendautopia.service");
	}
}
