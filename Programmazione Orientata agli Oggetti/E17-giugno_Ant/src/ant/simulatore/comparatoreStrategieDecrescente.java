package ant.simulatore;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import ant.Cibo;

public class comparatoreStrategieDecrescente implements Comparator<Class<?>> {


	private Map<Class<?>, Set<Cibo>> c2c;

	public comparatoreStrategieDecrescente(Map<Class<?>, Set<Cibo>> c2c) {

		this.c2c = c2c;
	}

	@Override
	public int compare(Class<?> o1, Class<?> o2) {

		return c2c.get(o2).size()-c2c.get(o1).size();
	}

}
