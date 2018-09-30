package api.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.products.model.Stack;

@Repository
public interface StackRepository extends JpaRepository<Stack, Long> {

}
