package br.com.projetoejb.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.projetoejb.models.Produto;


@Stateless
//@Interceptors({LogInterceptador.class})
public class ProdutoDao {
	
	@PersistenceContext
	EntityManager manager;
	
	public void persist(Produto produto) {

		this.manager.persist(produto);


	}

	public void remove(Produto produto) {

		this.manager.remove(this.manager.merge(produto));

	}

	public void merge(Produto produto) {

		this.manager.merge(produto);

	}

	@SuppressWarnings("unchecked")
	public List<Produto> findAll() {
		
		List<Produto> produtos = this.manager.createQuery("select p from Produto p").getResultList();

		return produtos;
	}

	public Produto findById(Integer id) {
		
		Produto produto = this.manager.find(Produto.class, id);

		return produto;
	}

	public int count() {
		
		long result = (Long) this.manager.createQuery("select count(p) from Produto p").getSingleResult();

		return (int) result;
	}

	public List<Produto> findByDesc(String descricao) {
		TypedQuery<Produto> query = this.manager.createQuery("select p from Produto p where p.descricao like :pDescricao", Produto.class);
		query.setParameter("pDescricao", "%" + descricao + "%");
		
		return query.getResultList();
	}
	
}
