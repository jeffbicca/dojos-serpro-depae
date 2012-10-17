package br.gov.serpro.dojo004

class Carrinho {
	
	def valorTotal = 0.0
	def produtos = []
	
	def size = {produtos.size}
	
	def plus(p) {
		p.each {
			produto -> 
			if(size() < 10) {
				if(valorTotal + produto.preco <= 100) {
					produtos += produto
					valorTotal += produto.preco
				} else {
					throw new RuntimeException("Valor excedido")
				}
			} else
				throw new RuntimeException("Carrinho cheio")
		}
		this
	}

}
