package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {

	public Comando costruisciComando(String istruzione) {

		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;

		if(scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		if(scannerDiParole.hasNext())
			parametro = scannerDiParole.next();

		if(nomeComando == null)
			comando = new ComandoNonValido();
		else if(nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if(nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if(nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if(nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if(nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if(nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else 
			comando = new ComandoNonValido();
		comando.setParametro(parametro);
		scannerDiParole.close();

		return comando;
	}



}
