package com.api.bonappetit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI bonappetitAPI() {
		return new OpenAPI().info(new Info().title("API Bonappetit")
				.description("API desenvolvida para a disciplina Desenvolvimento para Servidores-II <br><br>"
						+ "<strong>Integrantes do grupo:</strong><br> "
						+ "- Matheus Valencio Fonseca<br>"
						+ "- Isabella Mercedes Marques Trigo<br>"
						+ "- Caio Croccia Pereira de Carvalho").version("v0.0.1")
				.contact(new Contact().name("Matheus Valencio Fonseca")
						.email("matheus.fonseca5@fatec.sp.gov.br"))
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
		
	}
}
