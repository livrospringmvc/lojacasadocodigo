package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Produto;

@Repository
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void adiciona(Produto produto){
		manager.persist(produto);
	}

	public List<Produto> lista() {
		return manager.createQuery("select distinct(p) from Produto p join fetch p.valores",Produto.class).getResultList();
	}

	public Produto busca(Integer id) {
		return manager.find(Produto.class, id);
	}
}
