package br.com.projetoejb.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetoejb.daos.ProdutoService;
import br.com.projetoejb.models.Produto;

@Named
@RequestScoped
public class ProdutoBean implements Serializable{
	private static final long serialVersionUID = 6543839311388129620L;

	private List<Produto> produtos = new ArrayList<>();

	private Produto produto = new Produto();

	@Inject
	private ProdutoService produtoService;
	
	@Inject
	FacesContext context;
	
	//@Inject 
	//TesteSingleton testeSingleton;

	public ProdutoBean() {

		System.out.println("Nova instancia");
	}


	//@SuppressWarnings("static-access")
	//@Transactional o EJB por padrão ja faz o controle pelo container
	public String salvar() {
		System.out.println("REALIZANDO A FUNCAO DE SALVAR");

		if (produto.getId() == null) {
			this.produtoService.persist(produto);

			this.context.getExternalContext().getFlash().setKeepMessages(true);
			this.context.addMessage(null, new FacesMessage("Produto cadastrado com sucesso!"));
		}
		
		
		//System.out.println(testeSingleton.TESTE);
		
		return "home?faces-redirect=true";
		//return "";
	}
	
	public List<Produto> listar() {
		return this.produtoService.findAll();
	}
	
	public int contarProdutos() {
		return this.produtoService.count();
	}

	public Produto pesquisarProduto(Integer id) {
		return this.produtoService.findById(id);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
