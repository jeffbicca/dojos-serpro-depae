package br.gov.serpro.dojo003;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.gov.serpro.dojo003.service.NetworkException;
import br.gov.serpro.dojo003.service.Operadora;
import br.gov.serpro.dojo003.service.SMS;
import br.gov.serpro.dojo003.service.SMSSender;

import static org.fest.assertions.api.Assertions.assertThat;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

public class SMSSenderTest {
	@Mock
	private SMSSender smsSender;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deveEnviarEDebitar() throws NetworkException {
		doNothing().when(smsSender).send("12345678", "Oi", Operadora.CLARO);
		doReturn(2L).when(smsSender).getDebit();
		doReturn(Collections.singletonList(new SMS())).when(smsSender).getMessagesSent();

		smsSender.send("12345678", "Oi", Operadora.CLARO);

		assertThat(smsSender.getDebit()).isEqualTo(new Long(2L));
		assertThat(smsSender.getMessagesSent()).hasSize(1);
	}

	@Test(expected = NetworkException.class)
	public void deveEnviarNumeroInvalidoEDarErro() throws NetworkException {
		doThrow(NetworkException.class).when(smsSender).send("número inválido", "Oi", Operadora.OI);

		smsSender.send("número inválido", "Oi", Operadora.OI);
	}

	@Test(expected = NetworkException.class)
	public void deveEnviarOperadoraInvalidaEDarErro() throws NetworkException {
		doThrow(NetworkException.class).when(smsSender).send("12345678", "Oi", null);

		smsSender.send("12345678", "Oi", null);
	}

	@Test
	public void Maior140CharDarErro() throws NetworkException {
		NetworkException networkException = new NetworkException("[INFO] Your message could not pass 140 characters.");
		doThrow(networkException)
				.when(smsSender)
				.send("12345678",
						"0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789",
						Operadora.TIM);

		try {
			smsSender
					.send("12345678",
							"0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789",
							Operadora.TIM);
		} catch (NetworkException e) {
			assertThat(e.getMessage()).isEqualTo("[INFO] Your message could not pass 140 characters.");
		}

	}

	@Test(expected = NetworkException.class)
	public void deveDarErroMais3Msgs() throws NetworkException {
		doThrow(NetworkException.class).when(smsSender).send("12345678", "Oi", Operadora.OI);

		smsSender.send("12345678", "Oi", Operadora.OI);
		smsSender.send("12345678", "Oi2", Operadora.OI);
		smsSender.send("12345678", "Oi3", Operadora.OI);
		smsSender.send("12345678", "Oi4", Operadora.OI);

		assertThat(smsSender.getMessagesSent()).hasSize(3);
	}

}
