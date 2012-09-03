package br.gov.serpro.dojo002;

import java.math.BigDecimal;

public class Calculadora {
	
	private BigDecimal numero1;
	private BigDecimal numero2;
	private BigDecimal total;
	
	public void soma() {
		this.total = numero1.add(numero2);
	}
	
	public void subtrai() {
		this.total = numero1.subtract(numero2);
	}

	public BigDecimal getNumero1() {
		return numero1;
	}
	public void setNumero1(BigDecimal numero1) {
		this.numero1 = numero1;
	}

	public BigDecimal getNumero2() {
		return numero2;
	}
	public void setNumero2(BigDecimal numero2) {
		this.numero2 = numero2;
	}

	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
