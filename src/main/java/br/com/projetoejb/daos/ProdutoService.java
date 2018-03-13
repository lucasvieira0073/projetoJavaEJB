package br.com.projetoejb.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.projetoejb.models.Produto;

@Stateless
public class ProdutoService {

	@Inject
	ProdutoDao produtoDao;
	
	public void persist(Produto produto){
		produtoDao.persist(produto);
	}
	
	public List<Produto> findAll() {
		return produtoDao.findAll();
	}
	
	public Produto findById(Integer id) {
		return produtoDao.findById(id);
	}
	
	public int count() {
		return produtoDao.count();
	}
}
