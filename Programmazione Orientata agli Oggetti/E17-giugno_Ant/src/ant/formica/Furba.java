package ant.formica;

import static ant.costanti.CostantiGUI.IMMAGINE_FORMICA_BIANCA;

import java.awt.Image;
import java.util.Set;

import ant.Ambiente;
import ant.Coordinate;
import ant.Direzione;

public class Furba extends Inseguitrice {

	private static int progId=0;

	public Furba(Ambiente ambiente) {
		super(progId++, ambiente);
	}

	@Override
	public boolean decideDiCambiareDirezione() {
		return true;
	}
	
	@Override
	protected Direzione scegliDirezioneDopoPerditaTraccia(Set<Direzione> possibili) {
		
		Direzione prossima = this.getAmbiente().getDirezioneCiboVicino(this.getPosizione());
		
		if(prossima!=null)
			return prossima;
		else
			return super.scegliDirezioneDopoPerditaTraccia(possibili);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_FORMICA_BIANCA;
	}

}
