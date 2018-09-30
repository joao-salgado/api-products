package api.products.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("products")
public class PropertyApiConfig {

	private String originPermitted;

	public String getOriginPermitted() {
		return originPermitted;
	}

	public void setOriginPermitted(String originPermitted) {
		this.originPermitted = originPermitted;
	}
	
}

