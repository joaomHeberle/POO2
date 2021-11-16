package jogo.views;

import application.Main;
import jogo.models.Player2;
import jplay.Keyboard;
import jplay.Scene;

import jplay.Window;

public class Cenario2 extends Cenario {
	private Window janela;
	private Scene cena;
	private Player2 player;
	private Keyboard teclado;
	public static int tam = 20;


	public Cenario2(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/recursos/scn/cenario2.scn");
		player = new Player2(600, 500);
		teclado = janela.getKeyboard();
		

		//Som.play("src/recursos/audio/Path.mid");
		run();
	}

	private void run() {

		while (true) {
			// cena.draw();
			player.controle(janela, teclado);
			player.caminho(cena);

			cena.moveScene(player);
//		player.x += cena.getXOffset();
//			player.y += cena.getYOffset();
	
			player.draw();
			janela.update();
			mudarCenario();
			pegarMissao();
		}

	}
	private void mudarCenario() {
		if(tileCollision(63, player, cena)==true) {
			new Cenario1(janela);
		}
		
	}
	private void pegarMissao() {
		if(tileCollision(66, player, cena)==true) {
			Main.loadScene("Inicio");
		}
		
	}
	
	
}
