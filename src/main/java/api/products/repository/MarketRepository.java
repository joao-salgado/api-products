package api.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.products.model.Market;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {

}
