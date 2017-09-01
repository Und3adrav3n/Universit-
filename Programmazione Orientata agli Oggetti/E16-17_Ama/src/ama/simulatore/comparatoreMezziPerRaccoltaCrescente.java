package ama.simulatore;

import java.util.Comparator;
import java.util.Map;

import ama.mezzo.Mezzo;

public class comparatoreMezziPerRaccoltaCrescente implements Comparator<Mezzo> {

	Map<Mezzo, Integer> mezzo2quantita;

	public comparatoreMezziPerRaccoltaCrescente(Map<Mezzo, Integer> mezzo2quantita) {
		this.mezzo2quantita=mezzo2quantita;
	}

	@Override
	public int compare(Mezzo arg0, Mezzo arg1) {
		return mezzo2quantita.get(arg0)-mezzo2quantita.get(arg1);
	}

}
