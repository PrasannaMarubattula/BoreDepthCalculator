package com.groundwater.boredepth.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config {

	@Bean
	public Docket api() {
		
		//final String host = "localhost:8080";
		
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).apiInfo(apiInfo()).
						securityContexts(Arrays.asList(securityContext())).
						securitySchemes(Arrays.asList(apiKey())).
						pathMapping("/")
						.select()
				.apis(RequestHandlerSelectors.basePackage("com.groundwater.boredepth.controller"))

				.paths(PathSelectors.ant("/**")).build();

	}




	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}



	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Bore Depth Calculator", "Some custom description of API.", "@", "Terms of service",  contact(),
				"License of API's", "API license URL", Collections.emptyList());
	}

	private Contact contact() {
		return new Contact("Hemanth","https://Hemanth.com/","Hemanth.pmm@gmail.com");

	}
	
}
