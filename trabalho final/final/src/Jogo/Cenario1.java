package Jogo;

import jplay.Keyboard;
import jplay.Scene;

import jplay.Window;

public class Cenario1 {
	private Window janela;
	private Scene cena;
	private Player player;
	private Keyboard teclado;
	private Zumbie zum[];

	public Cenario1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/recursos/scn/cenario1.scn");
		player = new Player(750,550);
		teclado = janela.getKeyboard();
		zum=new Zumbie[10];
		
		Som.play("src/recursos/audio/Path.mid");
		run();
	}

	private void run() {
		
		for (int i = 0; i < zum.length; i++) {
			zum[i] = new Zumbie((0+i)*i,0);
		}
		
		
		while (true) {
			//cena.draw();
			player.controle(janela,teclado);
			player.caminho(cena);
			
			
			cena.moveScene(player);
			player.x+=cena.getXOffset();
			player.y+=cena.getYOffset();
			
			for (int i = 0; i < zum.length; i++) {
				
	
			
			zum[i].x+=cena.getXOffset();
			zum[i].y+=cena.getYOffset();
			zum[i].caminho(cena);
			zum[i].perseguir(player.x, player.y);
			zum[i].draw();
			player.atirar(janela, cena, teclado,zum[i]);
			zum[i].morrer();
			zum[i].atacar(player);
			
			}
			player.energia(janela);
		
			
			player.draw();
			janela.update();

		}
	}
}
