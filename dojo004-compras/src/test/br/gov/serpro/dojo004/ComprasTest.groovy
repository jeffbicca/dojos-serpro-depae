package br.gov.serpro.dojo004

import org.junit.Assert;
import org.junit.Test;

class ComprasTest {
	
	@Test
	def void deveIncluirUmProdutoNoCarrinho() {
		def produto = new Produto(nome: "Guinness", preco: 10.0)
		def carrinho = new Carrinho()
		carrinho += produto
		Assert.assertEquals(1, carrinho.size())
	}
	
	@Test
	def void deveIncluirDoisProdutosNoCarrinho() {
		def produto1 = new Produto(nome: "Guinness", preco: 10.0)
		def produto2 = new Produto(nome: "Heineken", preco: 7.0)
		
		def carrinho = new Carrinho()
		carrinho += produto1
		carrinho += produto2
		Assert.assertEquals(2, carrinho.size())
	}
	
	@Test(expected=RuntimeException.class)
	def void deveImpedirInclusaoOnzeProdutosNoCarrinho() {
		def onzeProdutos = {
			def lista = []
			for(p in (0..10))
				lista+= new Produto(nome: "Guinness ${p}", preco: p)
			lista
		}
		
		def carrinho = new Carrinho()
		carrinho += onzeProdutos()
	}
	
	@Test
	def void deveIncluirSemExcederLimiteValor() {
		def produto1 = new Produto(nome:"Produto1", preco:75)
		def produto2 = new Produto(nome:"Produto2", preco:25)
		
		def carrinho = new Carrinho()
		carrinho += produto1
		carrinho += produto2
		
		Assert.assertEquals(100.0, carrinho.valorTotal)
		
	}
	
	@Test
	def void deveImpedirInclusaoExcedendoLimiteValor() {
		def produto1 = new Produto(nome:"Produto1", preco:75)
		def produto2 = new Produto(nome:"Produto2", preco:26)
		
		def carrinho = new Carrinho()
		try {
			carrinho += produto1
			carrinho += produto2
		} catch(RuntimeException e) {
			Assert.assertEquals("Valor excedido", e.message)
		} 
		
	}

}
