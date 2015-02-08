package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

@Repository
public class ProductDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Product produto) {
		manager.persist(produto);
	}

	public List<Product> list() {
		return manager.createQuery(
				"select distinct(p) from Product p join fetch p.prices",
				Product.class).getResultList();
	}

	public Product find(Integer id) {
		TypedQuery<Product> query = manager
				.createQuery(
						"select distinct(p) from Product p join fetch p.prices where p.id=:id",
						Product.class).setParameter("id", id);
		return query.getSingleResult();
	}

	public Product findBy(Integer id, BookType bookType) {
		TypedQuery<Product> query = manager
				.createQuery(
						"select p from Product p join fetch p.prices price where p.id = :id and price.bookType = :bookType",
						Product.class);
		query.setParameter("id", id);
		query.setParameter("bookType", bookType);
		return query.getSingleResult();
	}
}
