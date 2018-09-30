package api.products.repository.query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.products.repository.dto.ProductDTO;
import api.products.repository.filter.ProductFilter;

public class ProductRepositoryImpl implements ProductRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ProductDTO> findByFilter(ProductFilter productFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
