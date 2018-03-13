package br.com.projetoejb.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.projetoejb.daos.ProdutoDao;
import br.com.projetoejb.models.Produto;

@WebService
@Stateless
public class ProjetoEJBWS {
	
	@Inject
	ProdutoDao produtoDao;

	@WebResult(name="produtos")
	public List<Produto> getProdutoPelaDescricao(@WebParam(name="titulo") String descricao) {
		System.out.println("ProjetoEJBWS: procurando pela descrição " + descricao);
		
		return produtoDao.findByDesc(descricao);
	}
}
