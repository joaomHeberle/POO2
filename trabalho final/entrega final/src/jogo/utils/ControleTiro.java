package jogo.utils;

import java.util.LinkedList;

import jogo.models.Ator;
import jplay.Scene;
import jplay.Sound;

public class ControleTiro {
	
	
	LinkedList<Tiro> tiros = new LinkedList<>();
	
	public void adicionaTiro(double x,double y,int caminho,Scene cena) {
		Tiro tiro = new Tiro(x,y,caminho);
		tiros.addFirst(tiro);
		cena.addOverlay(tiro);
		Som s = new Som();
		s.somDisparo();

	}
	public void run(Ator inimigo) {
		for (int i = 0; i < tiros.size(); i++) {
			Tiro tiro = tiros.removeFirst();
			tiro.mover();
			tiros.addLast(tiro);
			
			if(tiro.collided(inimigo)) {
				tiro.x=10_000;
				inimigo.energia-=250;
			}
			
		}
		

	}
	


}
