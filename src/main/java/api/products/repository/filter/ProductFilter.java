package api.products.repository.filter;

import java.util.List;

public class ProductFilter {
	
	private String name;
	
	private String description;

	private List<Long> markets;

	private List<Long> stacks;

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

	public List<Long> getMarkets() {
		return markets;
	}

	public void setMarkets(List<Long> markets) {
		this.markets = markets;
	}

	public List<Long> getStacks() {
		return stacks;
	}

	public void setStacks(List<Long> stacks) {
		this.stacks = stacks;
	}
	
}
