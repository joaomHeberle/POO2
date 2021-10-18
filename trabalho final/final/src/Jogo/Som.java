package Jogo;

import jplay.Sound;

public class Som {
	
	private static Sound musica;
	
	public static void play(String audio) {
		stop();
		musica = new Sound(audio);
	
		Som.musica.play();
		Som.musica.setRepeat(true);
		Som.musica.setVolume(-20);
	}
	
	public static void stop() {
		if(Som.musica!=null) {
			musica.stop();
		}
		
	}
	
	public void somDisparo() {

	new Sound("src/recursos/audio/laser.wav").play();
	}

}
