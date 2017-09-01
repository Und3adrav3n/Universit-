package battlefield;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import battlefield.robot.Robot;
import battlefield.robot.Walker;

public class RobotOrdinatiPerPosizioneTest {

	private Battlefield field;
	private Robot r1, r2, r3, r4;
	private List<Robot> expected;
	private List<?> actual;

	@Before
	public void setUp(){
		field = new Battlefield(2);

		r1 = new Walker(new Position(0, 0));
		r2 = new Walker(new Position(0, 1));
		r3 = new Walker(new Position(1, 0));
		r4 = new Walker(new Position(1, 1));

		expected = new ArrayList<>();
	}

	@Test
	public void testVuoto(){
		actual = field.getRobotOrdinatiPerPosizione();
		assertEquals(expected, actual);
	}

	@Test
	public void testSingolo()
	{
		field.addRobot(r1);
		actual = field.getRobotOrdinatiPerPosizione();
		
		expected.add(r1);

		assertEquals(expected, actual);
	}

	@Test
	public void testXdiversa()
	{
		field.addRobot(r3);
		field.addRobot(r1);
		actual = field.getRobotOrdinatiPerPosizione();
		
		expected.add(r1);
		expected.add(r3);
		
		assertEquals(expected, actual);
	}

	@Test
	public void testYdiversa()
	{
		field.addRobot(r2);
		field.addRobot(r1);
		actual = field.getRobotOrdinatiPerPosizione();

		expected.add(r1);
		expected.add(r2);
		
		assertEquals(expected, actual);
	}

	@Test
	public void test4robot()
	{
		field.addRobot(r2);
		field.addRobot(r3);
		field.addRobot(r4);
		field.addRobot(r1);
		actual = field.getRobotOrdinatiPerPosizione();
		
		expected.add(r1);
		expected.add(r2);
		expected.add(r3);
		expected.add(r4);
		
		assertEquals(expected, actual);
	}
}
