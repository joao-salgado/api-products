package api.products.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.products.repository.ProductRepository;
import api.products.repository.dto.ProductDTO;
import api.products.repository.filter.ProductFilter;

@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public Page<ProductDTO> findByFilter(ProductFilter productFilter, Pageable pageable) {
		return productRepository.findByFilter(productFilter, pageable);
	}
	
}
