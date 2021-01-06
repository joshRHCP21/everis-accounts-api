package com.bank.accounts;

import com.bank.accounts.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class AccountsApiApplication implements WebMvcConfigurer
{
	public static void main(String[] args) {
		SpringApplication.run(AccountsApiApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

	}
}
