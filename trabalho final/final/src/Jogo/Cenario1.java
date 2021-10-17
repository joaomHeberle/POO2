package Jogo;

import jplay.Keyboard;
import jplay.Scene;

import jplay.Window;

public class Cenario1 {
	private Window janela;
	private Scene cena;
	private Player player;
	private Keyboard teclado;
	private Zumbie zum;

	public Cenario1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/recursos/scn/cenario1.scn");
		player = new Player(600, 0);
		teclado = janela.getKeyboard();
		zum=new Zumbie(600, 100);
		
		Som.play("src/recursos/audio/Path.mid");
		run();
	}

	private void run() {
		while (true) {
			//cena.draw();
			player.controle(janela,teclado);
			player.caminho(cena);
			
			zum.caminho(cena);
			//zum.perseguir(player.x, player.y);
			cena.moveScene(player);
			player.x+=cena.getXOffset();
			player.y+=cena.getYOffset();
			
			
			
			zum.x+=cena.getXOffset();
			zum.y+=cena.getYOffset();
			 
			zum.draw();
			player.atirar(janela, cena, teclado,zum);
			zum.morrer();
			player.draw();
			janela.update();

		}
	}
}
