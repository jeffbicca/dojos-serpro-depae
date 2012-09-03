package br.gov.serpro.dojo002;

import java.util.HashMap;
import java.util.Map;

public class CaixaEletronico {

	private Integer valor;
	
	private Map<Integer,Integer> quantidade = new HashMap<Integer,Integer>();
	
	public CaixaEletronico() {
		getQuantidade().put(0, 0);
		getQuantidade().put(10, 0);
		getQuantidade().put(20, 0);
		getQuantidade().put(50, 0);
		getQuantidade().put(100, 0);
	}
	
	public void saque() {
		if (valor == 10) {
			getQuantidade().put(10,1);
		}
		if (valor == 40) {
			getQuantidade().put(20,2);
		}
		if (valor == 80) {
			getQuantidade().put(20,1);
			getQuantidade().put(10,1);
			getQuantidade().put(50,1);
		}
		
		
	}
	
	
	
	
	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Map<Integer,Integer> getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Map<Integer,Integer> quantidade) {
		this.quantidade = quantidade;
	}

	
}
