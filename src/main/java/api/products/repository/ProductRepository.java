package api.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.products.model.Product;
import api.products.repository.query.ProductRepositoryQuery;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryQuery {

}
