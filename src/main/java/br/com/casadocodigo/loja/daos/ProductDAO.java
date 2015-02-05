package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Product;

@Repository
public class ProductDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(Product produto){
		manager.persist(produto);
	}

	public List<Product> list() {
		return manager.createQuery("select distinct(p) from Product p join fetch p.prices",Product.class).getResultList();
	}

	public Product busca(Integer id) {
		return manager.find(Product.class, id);
	}
}
