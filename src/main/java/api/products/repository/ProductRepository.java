package api.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.products.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
