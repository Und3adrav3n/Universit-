package ant;

import static org.junit.Assert.*;

import org.junit.Test;

public class AmbienteTest {

	private Ambiente ambiente;

	@Test
	public void test1() {
		ambiente = new Ambiente(3);
		assertTrue(ambiente.getPossibiliDirezioni(new Coordinate(1, 1)).isEmpty());
	}
	
	@Test
	public void test2() {
		ambiente = new Ambiente(5);
		assertEquals(3, ambiente.getPossibiliDirezioni(new Coordinate(1, 1)).size());
	}
	
	@Test
	public void test3() {
		//TODO
	}

}
