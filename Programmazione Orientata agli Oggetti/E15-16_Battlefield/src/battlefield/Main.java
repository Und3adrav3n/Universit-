package battlefield;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import battlefield.robot.Robot;

public class Main {

	static final private int PASSI 		= 40;
	static final private int DIMENSIONE = 250;

	private Battlefield field;
	private Display display;
	
	public Main() {
		this.field = new Battlefield(DIMENSIONE);
		this.display = new Display(DIMENSIONE);
		this.field.riempi();
	}

	public void run() throws InstantiationException, IllegalAccessException {
		for(int i=0; i<PASSI; i++) {
			
			
			final List<Robot> allRobots = new ArrayList<>(this.field.getAllRobots());
			Collections.shuffle(allRobots);
			for(Robot c : allRobots) {
				c.passo(field);
			}
			/*DOMANDA 3
			final List<Walker> allWalkers = new ArrayList<>(this.field.getAllWalkers());
			Collections.shuffle(allWalkers);
			for(Walker w : allWalkers) {
				w.passo(field);
			}
			*/
			
			this.display.aggiornaSchermata(i, this.field);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new Main().run();
	}

}
