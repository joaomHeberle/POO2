package Jogo;

import jplay.Sound;

public class Som {
	
	private static Sound musica;
	
	public static void play(String audio) {
		stop();
		musica = new Sound(audio);
		Som.musica.play();
		Som.musica.setRepeat(true);
	}
	
	public static void stop() {
		if(Som.musica!=null) {
			musica.stop();
		}
		
	}

}
