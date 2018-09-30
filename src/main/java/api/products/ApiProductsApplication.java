package api.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import api.products.config.PropertyApiConfig;

@SpringBootApplication
@EnableConfigurationProperties(PropertyApiConfig.class)
public class ApiProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProductsApplication.class, args);
	}
}
