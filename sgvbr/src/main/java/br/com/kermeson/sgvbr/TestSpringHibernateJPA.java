package br.com.kermeson.sgvbr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.kermeson.sgvbr.entity.Produto;
import br.com.kermeson.sgvbr.service.ProdutoService;

public class TestSpringHibernateJPA {

	public static void main(String[] args) {
		System.out.println("************** BEGINNING PROGRAM **************");

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ProdutoService produtoService = (ProdutoService) context.getBean("produtoService");

		Produto produto = new Produto();
		produto.setNome("Bolinha de Carne");
		produto = produtoService.incluir(produto);
		System.out.println("Produto : " + produto.toString() + " added successfully");

		System.out.println("************** ENDING PROGRAM *****************");
	}
}