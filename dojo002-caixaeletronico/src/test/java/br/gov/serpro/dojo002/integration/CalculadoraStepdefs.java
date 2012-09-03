package br.gov.serpro.dojo002.integration;

import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;

import br.gov.serpro.dojo002.Calculadora;
import cucumber.annotation.pt.Dado;
import cucumber.annotation.pt.Entao;
import cucumber.annotation.pt.Quando;

public class CalculadoraStepdefs {
	
	Calculadora calculadora = new Calculadora();
	
    @Dado("^que informo os números (\\d+) e (\\d+)$")
    public void informo_o_numero(BigDecimal numero1, BigDecimal numero2) {
    	calculadora.setNumero1(numero1);
    	calculadora.setNumero2(numero2);
    }
    
    @Quando("^solicito que seja efetuada a \"([^\"]*)\"$")
    public void solicito_que_seja_efetuada_a(String operacao) {
		if("soma".equals(operacao))
			calculadora.soma();
		if("subtração".equals(operacao))
			calculadora.subtrai();
    }

    @Entao("^a operação deve retornar (\\d+)$")
    public void a_operacao_deve_retornar(BigDecimal total) {
        assertThat(calculadora.getTotal()).isEqualTo(total);
    }
    
}
