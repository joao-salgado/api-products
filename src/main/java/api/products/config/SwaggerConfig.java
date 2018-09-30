package api.products.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket beanDetails() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket.select().apis(RequestHandlerSelectors.basePackage("api.products")).paths(PathSelectors.any()).build()
				.apiInfo(this.informationsApi().build());
		return docket;
	}

	private ApiInfoBuilder informationsApi() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("Products API");
		apiInfoBuilder.description("Bis2Bis Test");
		apiInfoBuilder.contact(new Contact("João Salgado", "https://www.linkedin.com/in/joao-slgd/", "jgs1884@gmail.com"));
		return apiInfoBuilder;
	}

}
