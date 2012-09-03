package br.gov.serpro.dojo002.integration;

import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;

import br.gov.serpro.dojo002.CaixaEletronico;
import cucumber.annotation.pt.Dado;
import cucumber.annotation.pt.E;
import cucumber.annotation.pt.Entao;
import cucumber.annotation.pt.Quando;

public class CaixaEletronicoStepdefs {
	
	CaixaEletronico caixaEletronico = new CaixaEletronico();
	
    @Dado("^que informo um valor de saque de (\\d+) reais$")
    public void informo_o_valor_do_saque(Integer valor) {
    	caixaEletronico.setValor(valor);
    }
    
    @Quando("^solicito que seja efetuado um saque$")
    public void solicito_que_seja_efetuado_um_saque() {
    	caixaEletronico.saque();
    }

    @Entao("^o saque deve retornar (\\d+) nota de (\\d+) reais$")
    public void o_saque_deve_retornar(Integer quantidadeNotas, Integer valorNota) {
    	assertThat(caixaEletronico.getQuantidade().get(valorNota)).isEqualTo(quantidadeNotas);    	
    }
    
    @E("^(\\d+) nota de (\\d+) reais$")
    public void o_saque_deve_retornarE(Integer quantidadeNotas, Integer valorNota) {
    	assertThat(caixaEletronico.getQuantidade().get(valorNota)).isEqualTo(quantidadeNotas);    	
    }
    
    
}   
