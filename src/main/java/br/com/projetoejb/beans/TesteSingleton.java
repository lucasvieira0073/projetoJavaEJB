package br.com.projetoejb.beans;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class TesteSingleton {
	
	
	public static String TESTE = "TESTE DE SINGLETON";
	
	@PostConstruct
	public void teste() {
		System.out.println("Teste de startup singleton");
	}
}
