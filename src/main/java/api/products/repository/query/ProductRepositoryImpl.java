package api.products.repository.query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import api.products.model.Market;
import api.products.model.Product;
import api.products.repository.dto.ProductDTO;
import api.products.repository.filter.ProductFilter;

public class ProductRepositoryImpl implements ProductRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ProductDTO> findByFilter(ProductFilter productFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ProductDTO> criteria = builder.createQuery(ProductDTO.class);
		Root<Product> root = criteria.from(Product.class);

		CriteriaQuery<Market> criteriaQuery = builder.createQuery(Market.class);
		Root<Product> productRoot = criteriaQuery.from(Product.class);
		Join<Object, Object> productJoin = productRoot.join("markets");
		CriteriaQuery<Market> cq = criteriaQuery.multiselect(productJoin);
		manager.createQuery(cq);

		criteria.select(builder.construct(ProductDTO.class, productJoin)).orderBy(builder.asc(root.get("id")));

		Predicate[] predicates = createRestrictions(productFilter, builder, root);
		criteria.where(predicates);
		criteria.groupBy(root.get("id"));

		TypedQuery<ProductDTO> query = manager.createQuery(criteria);
		addRestrictionsPage(query, pageable);

		return new PageImpl<ProductDTO>(query.getResultList().stream().distinct().collect(Collectors.toList()), pageable,
				total(productFilter));
	}

	private Predicate[] createRestrictions(ProductFilter productFilter, CriteriaBuilder builder, Root<Product> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!StringUtils.isEmpty(productFilter.getName())) {
			predicates.add(builder.like(root.get("name"), "%" + productFilter.getName() + "%"));
		}
		
		if (!StringUtils.isEmpty(productFilter.getDescription())) {
			predicates.add(builder.like(root.get("description"), "%" + productFilter.getDescription() + "%"));
		}

		if (productFilter.getMarkets() != null) {
			Expression<Integer> marketExpression = root.join("markets").get("id");
			predicates.add(marketExpression.in(productFilter.getMarkets()));
		}
		
		if (productFilter.getStacks() != null) {
			Expression<Integer> stackExpression = root.join("stacks").get("id");
			predicates.add(stackExpression.in(productFilter.getStacks()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void addRestrictionsPage(TypedQuery<?> query, Pageable pageable) {
		int actualPage = pageable.getPageNumber();
		int totalPerPage = pageable.getPageSize();
		int firstRegister = actualPage * totalPerPage;

		query.setFirstResult(firstRegister);
		query.setMaxResults(totalPerPage);
	}

	private Long total(ProductFilter productFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Product> root = criteria.from(Product.class);

		Predicate[] predicates = createRestrictions(productFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}
