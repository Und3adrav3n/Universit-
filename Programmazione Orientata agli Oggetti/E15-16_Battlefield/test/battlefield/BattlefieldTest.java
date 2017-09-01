package battlefield;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import battlefield.robot.Chaser;
import battlefield.robot.Robot;
import battlefield.robot.Walker;

/* Modificare la classe Position affinche' 
 * il primo test abbia successo (vedi DOMANDA 1) 
 */
public class BattlefieldTest {
	
	private Battlefield field;
	private Robot c1, w1;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
		c1 = new Chaser(new Position(1, 0));
		w1 = new Walker(new Position(0, 0));
	}

	@Test
	public void testAddWalker() {
		assertEquals(0, this.field.getAllRobots().size());
		this.field.addRobot(new Walker(new Position(0,0)));
		assertEquals(1, this.field.getAllRobots().size());
	}
	
	@Test
	public void testRaggruppaRobotDiDueTipiDiversi() {
		
		//VALORE ATTUALE
		field.addRobot(c1);
		field.addRobot(w1);
		
		Map<Class<?>, Set<?>> actual = field.raggruppaRobotPerTipo();
		
		//VALORE ATTESO
		Class<?> key;
		//Preparazione mappa expected
		Map<Class<?>, Set<Robot>> expected = new HashMap<>();
		//preparazione elementi mappa
		Set<Robot> c = new HashSet<>();
		c.add(c1);
		Set<Robot> w = new HashSet<>();
		w.add(w1);
		//inserimento elementi nella mappa
		key = Walker.class;
		expected.put(key, w);
		key = Chaser.class;
		expected.put(key, c);
		
		assertEquals(expected, actual);
	}

}
