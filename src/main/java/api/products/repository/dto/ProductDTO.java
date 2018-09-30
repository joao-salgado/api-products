package api.products.repository.dto;

import java.util.List;
import java.util.stream.Collectors;

import api.products.model.Product;

public class ProductDTO {
	
	private String name;

	private String description;

	private List<String> markets;

	private List<String> stacks;

	public ProductDTO(Product product) {
		this.name = product.getName();
		this.description = product.getDescription();
		this.markets = product.getMarkets().stream().map(m -> m.getName()).collect(Collectors.toList());
		this.stacks = product.getStacks().stream().map(m -> m.getName()).collect(Collectors.toList());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getMarkets() {
		return markets;
	}

	public void setMarkets(List<String> markets) {
		this.markets = markets;
	}

	public List<String> getStacks() {
		return stacks;
	}

	public void setStacks(List<String> stacks) {
		this.stacks = stacks;
	}
	
}
