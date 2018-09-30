package api.products;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import api.products.repository.ProductRepository;
import api.products.repository.dto.ProductDTO;
import api.products.repository.filter.ProductFilter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTests {

	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void findByStacksTest() {
		ProductFilter productFilter = new ProductFilter();
		
		List<Long> stacks = new ArrayList<Long>();
		stacks.add(1l);
		stacks.add(2l);
		
		productFilter.setStacks(stacks);
		
		Page<ProductDTO> pageObject = productRepository.findByFilter(productFilter, PageRequest.of(0, 999));
		
		assertEquals(1, pageObject.getTotalElements());
		assertEquals(true, pageObject.getContent().get(0).getStacks().contains("Java 10"));
		assertEquals(true, pageObject.getContent().get(0).getStacks().contains("Kotlin"));
	}
	
	@Test
	public void findByMarketsTest() {
		ProductFilter productFilter = new ProductFilter();
		
		List<Long> markets = new ArrayList<Long>();
		markets.add(5l);
		
		productFilter.setMarkets(markets);
		
		Page<ProductDTO> pageObject = productRepository.findByFilter(productFilter, PageRequest.of(0, 999));
		
		assertEquals(1, pageObject.getTotalElements());
		assertEquals(true, pageObject.getContent().get(0).getMarkets().contains("Telecom"));
	}
	
}
