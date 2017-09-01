package battlefield;

import java.util.Comparator;

import battlefield.robot.Robot;

public class ComparatorePerXpoiY implements Comparator<Robot> {

	@Override
	public int compare(Robot o1, Robot o2) {
		
		int comparatore;
		
		comparatore = o1.getPosizione().getX()-o2.getPosizione().getX();
		
		if(comparatore == 0)
			comparatore = o1.getPosizione().getY()-o2.getPosizione().getY();
		
		return comparatore;
	}

	
}
