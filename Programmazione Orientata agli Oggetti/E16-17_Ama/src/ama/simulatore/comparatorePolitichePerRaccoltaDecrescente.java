package ama.simulatore;

import java.util.Comparator;
import java.util.Map;

public class comparatorePolitichePerRaccoltaDecrescente implements Comparator<Class<?>>{

	Map<Class<?>, Integer> politica2quantita;

	public comparatorePolitichePerRaccoltaDecrescente(Map<Class<?>, Integer> politica2quantita) {
		this.politica2quantita=politica2quantita;
	}

	@Override
	public int compare(Class<?> o1, Class<?> o2) {
		return politica2quantita.get(o2)-politica2quantita.get(o1);
	}

}
