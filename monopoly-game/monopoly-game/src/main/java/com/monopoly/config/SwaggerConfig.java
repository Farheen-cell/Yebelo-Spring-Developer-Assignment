package com.monopoly.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI().info(new Info().title("monopoly-game")

						.description("Backend APIs for monopoly-game")
						.version("v1.0.0")
						.contact(new Contact().name("Farheen Ali").url("https://github.com/Farheen-cell").email("farheen.ali108@gmail.com"))
						.license(new License().name("License").url("/")))
				.externalDocs(new ExternalDocumentation().description("Monopoly-Game App Documentation")
						.url("http://localhost:8080/swagger-ui/index.html"));

	}

}
