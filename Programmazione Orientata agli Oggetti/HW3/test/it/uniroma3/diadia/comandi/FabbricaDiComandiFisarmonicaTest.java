package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbricaDiComandiFisarmonica;
	private Comando comando;
	@Before
	public void setUp() throws Exception {
		fabbricaDiComandiFisarmonica = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testCostruisciComando_AiutoNome() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("aiuto");
		assertEquals("Aiuto", comando.getNome());
	}

	@Test
	public void testCostruisciComando_AiutoParametro() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("aiuto");
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComando_FineNome() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("fine");
		assertEquals("Fine", comando.getNome());
	}

	@Test
	public void testCostruisciComando_FineParametro() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("fine");
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComando_GuardaNome() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("guarda");
		assertEquals("Guarda", comando.getNome());
	}

	@Test
	public void testCostruisciComando_GuardaParametro() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("guarda");
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComando_NonValidoNome() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("inesistente");
		assertEquals("NonValido",comando.getNome());
	}

	@Test
	public void testCostruisciComando_NonValidoParametro() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("inesistente");
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComando_PosaNome() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("posa");
		assertEquals("Posa",comando.getNome());
	}

	@Test
	public void testCostruisciComando_PosaParametroNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("posa");
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComando_PosaParametroNonNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("posa Parametro");
		assertEquals("Parametro",comando.getParametro());
	}

	@Test
	public void testCostruisciComando_PosaSetParametroNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("posa");
		comando.setParametro("Parametro");
		assertEquals("Parametro",comando.getParametro());
	}

	@Test
	public void testCostruisciComando_PosaSetParametroNonNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("posa VecchioParametro");
		comando.setParametro("NuovoParametro");
		assertEquals("NuovoParametro",comando.getParametro());
	}
	
	@Test
	public void testCostruisciComando_PrendiNome() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("prendi");
		assertEquals("Prendi",comando.getNome());
	}

	@Test
	public void testCostruisciComando_PrendiParametroNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("prendi");
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComando_PrendiParametroNonNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("prendi Parametro");
		assertEquals("Parametro",comando.getParametro());
	}

	@Test
	public void testCostruisciComando_PrendiSetParametroNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("prendi");
		comando.setParametro("Parametro");
		assertEquals("Parametro",comando.getParametro());
	}

	@Test
	public void testCostruisciComando_PrendiSetParametroNonNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("prendi VecchioParametro");
		comando.setParametro("NuovoParametro");
		assertEquals("NuovoParametro",comando.getParametro());
	}
	
	@Test
	public void testCostruisciComando_VaiNome() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("vai");
		assertEquals("Vai",comando.getNome());
	}

	@Test
	public void testCostruisciComando_VaiParametroNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("vai");
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComando_VaiParametroNonNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("vai Parametro");
		assertEquals("Parametro",comando.getParametro());
	}

	@Test
	public void testCostruisciComando_VaiSetParametroNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("vai");
		comando.setParametro("Parametro");
		assertEquals("Parametro",comando.getParametro());
	}

	@Test
	public void testCostruisciComando_VaiSetParametroNonNullo() {
		comando = fabbricaDiComandiFisarmonica.costruisciComando("vai VecchioParametro");
		comando.setParametro("NuovoParametro");
		assertEquals("NuovoParametro",comando.getParametro());
	}
}
