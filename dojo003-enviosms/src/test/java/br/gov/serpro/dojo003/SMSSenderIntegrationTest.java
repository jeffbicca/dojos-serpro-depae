package br.gov.serpro.dojo003;

import org.fest.assertions.api.Fail;
import org.junit.Test;

import br.gov.serpro.dojo003.service.NetworkException;
import br.gov.serpro.dojo003.service.Operadora;
import br.gov.serpro.dojo003.service.SMSSender;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Fail.fail;

public class SMSSenderIntegrationTest {

	private SMSSender smsSender = new SMSSender();

	@Test(expected = NetworkException.class)
	public void deveImpedirEnviarMaisDoQueTresMensagens() throws NetworkException {
		smsSender.send("12345678", "Oi", Operadora.VIVO);
		smsSender.send("12345678", "Oi2", Operadora.TIM);
		smsSender.send("12345678", "Oi3", Operadora.CLARO);
		smsSender.send("12345678", "Oi4", Operadora.VIVO);

		assertThat(smsSender.getMessagesSent()).hasSize(4);
	}

	@Test
	public void deveDebitarNovePilas() throws NetworkException {
		smsSender.send("12332165", "Oi da Claro", Operadora.CLARO);
		smsSender.send("12332165", "Oi da Tim", Operadora.TIM);
		smsSender.send("12332165", "Oi da Vivo", Operadora.VIVO);

		assertThat(smsSender.getDebit()).isEqualTo(9L);
	}

	@Test
	public void deveImpedirEnvioDeSMSMaiorQue140Caracteres() {
		try {
			smsSender
					.send("12332165",
							"0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789",
							Operadora.CLARO);
		} catch (NetworkException e) {
			assertThat(e.getMessage()).isEqualTo("[INFO] Your message could not pass 140 characters.");
			return;
		}
		fail("Não gerou exceção ou mensagem não foi detectada corretamente.");
	}

	@Test(expected = NetworkException.class)
	public void deveEnviar4Mensagens3ProMesmoNumeroE1PraOutroNumero() throws NetworkException {
		smsSender.send("12332165", "Oi da Claro", Operadora.CLARO);
		smsSender.send("12332165", "Oi da Tim", Operadora.TIM);
		smsSender.send("12332165", "Oi da Vivo", Operadora.VIVO);
		smsSender.send("12332165", "Oi da Tim", Operadora.TIM);
	}

	@Test
	public void deveImpedirEnvioDeSMSParaNumeroComTamDiferenteDe8Digitos() {
		try {
			smsSender.send("1234567", "Mensagem", Operadora.CLARO);
		} catch (NetworkException e) {
			assertThat(e.getMessage()).isEqualTo("[INFO] Invalid number: 1234567");
			return;
		}
		Fail.fail("Não gerou exceção ou mensagem não foi detectada corretamente.");
	}

}
