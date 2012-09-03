package br.gov.serpro.dojo001;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TelefoneTeste {
	
	TelefoneCalculo telefoneCalculo = new TelefoneCalculo();
	
	@Test
	public void deveReceberLetraAERetornarNumero2() {
		assertEquals(new Integer(2), telefoneCalculo.getNumberByChar('a'));
		assertEquals(new Integer(2), telefoneCalculo.getNumberByChar('A'));
	}
	
	@Test
	public void deveReceberLetraBERetornarNumero2() {
		assertEquals(new Integer(2), telefoneCalculo.getNumberByChar('b'));
		assertEquals(new Integer(2), telefoneCalculo.getNumberByChar('B'));
	}
	
	@Test
	public void deveReceberLetraCERetornarNumero2() {
		assertEquals(new Integer(2), telefoneCalculo.getNumberByChar('c'));
		assertEquals(new Integer(2), telefoneCalculo.getNumberByChar('C'));
	}
	
	@Test
	public void deveReceberLetraDERetornarNumero3() {
		assertEquals(new Integer(3), telefoneCalculo.getNumberByChar('d'));
		assertEquals(new Integer(3), telefoneCalculo.getNumberByChar('D'));
	}

	@Test
	public void deveReceberABERetornar22() {
		assertEquals("22", telefoneCalculo.getNumberByString("ab"));
		assertEquals("22", telefoneCalculo.getNumberByString("AB"));
	}

	@Test
	public void deveReceberBICCAERetornar24222() {
		assertEquals("24222", telefoneCalculo.getNumberByString("bicca"));
		assertEquals("24222", telefoneCalculo.getNumberByString("BiCca"));
		assertEquals("24222", telefoneCalculo.getNumberByString("BICCA"));
	}
	
	@Test
	public void deveReceberGLENIORetornar453646() {
		assertEquals("453646", telefoneCalculo.getNumberByString("glenio"));
		assertEquals("453646", telefoneCalculo.getNumberByString("Glenio"));
		assertEquals("453646", telefoneCalculo.getNumberByString("GLENIO"));
	}
	
	@Test
	public void deveReceberSERPRORetornar737776() {
		assertEquals("deveria retornar 737776", "737776", telefoneCalculo.getNumberByString("SERPRO"));
		assertNull("Deveria retornar null", telefoneCalculo.getNumberByString("INV@LIDO"));
	}
	
	@Test
	public void deveReceberUVARetornar882() {
		assertEquals("deveria retornar 882", "882", telefoneCalculo.getNumberByString("UvA"));
	}
		
	@Test
	public void deveReceberXADREZRetornar923739() {
		assertEquals("deveria retornar 923739", "923739", telefoneCalculo.getNumberByString("xaDreZ"));
	}
	
	@Test
	public void deveMostrarErro() {
		assertNull(telefoneCalculo.getNumberByChar('?'));
		assertNull(telefoneCalculo.getNumberByChar('#'));
	}
	
	@Test
	public void deveMostrarErroString() {
		assertNull(telefoneCalculo.getNumberByString("??"));
		assertNull(telefoneCalculo.getNumberByString("BI#CA"));
	}	
	
	@Test
	public void deveReceberNullERetornarNull(){
		assertNull(telefoneCalculo.getNumberByChar(null));
	}
	
}
