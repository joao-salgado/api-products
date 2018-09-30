package api.products.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.products.model.Market;
import api.products.repository.MarketRepository;

@RestController
@RequestMapping("/markets")
public class MarketResource {

	@Autowired
	private MarketRepository marketRepository;

	@GetMapping
	public List<Market> findAll() {
		return marketRepository.findAll();
	}
	
}
