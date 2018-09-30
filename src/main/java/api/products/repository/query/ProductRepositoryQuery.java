package api.products.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.products.repository.dto.ProductDTO;
import api.products.repository.filter.ProductFilter;

public interface ProductRepositoryQuery {

	public Page<ProductDTO> findByFilter(ProductFilter productFilter, Pageable pageable);
	
}
