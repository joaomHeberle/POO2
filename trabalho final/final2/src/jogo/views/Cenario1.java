package jogo.views;


import jogo.models.Player;
import jogo.models.Zumbie;
import jogo.utils.Som;
import jplay.Keyboard;
import jplay.Scene;

import jplay.Window;

public class Cenario1 extends Cenario{
	private Window janela;
	private Scene cena;
	private Player player;
	private Keyboard teclado;
	public static int tam =20;
	private Zumbie zum[];
	private int id;
	
	public Cenario1(Window window,int id) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/recursos/scn/cenario1.scn");
		player = new Player(400, 500, id);
		teclado = janela.getKeyboard();
		zum = new Zumbie[tam];
		this.id=id;
		Som.play("src/recursos/audio/Path.mid");
		run();
	}

	private void run() {
		
			for (int i = 0; i < zum.length; i++) {
				if(i>=0&&i<10) {
					zum[i] = new Zumbie((0 + i) *60,0);  //fila de cima
				}else if(i>=10&&i<15){
					zum[i] = new Zumbie((0 + i) *20,50); //fila do meio
				}else {
					zum[i] = new Zumbie((0 + i)*20,100); //fila de baixo
				}
				
			}

			while (true) {
				// cena.draw();
				player.controle(janela, teclado);
				player.caminho(cena);

				cena.moveScene(player);
				player.x += cena.getXOffset();
				player.y += cena.getYOffset();
			
				for (int i = 0; i < zum.length-1; i++) {

					zum[i].x += cena.getXOffset();
					zum[i].y += cena.getYOffset();
					zum[i].caminho(cena);
					if(zum[i].tocou) {
						System.exit(0);
					}
					//zum[i].perseguir(player.x, player.y);
					zum[i].mover(janela);
					zum[i].draw();
					player.atirar(janela, cena, teclado, zum[i]);
					
					zum[i].morrer(player);
					
					zum[i].atacar(player);

				}
				
			
					
				
				zum[19].x += cena.getXOffset();
				zum[19].y += cena.getYOffset();
				
				zum[19].caminho(cena);
				if(zum[19].tocou) {
					System.exit(0);
				}
				zum[19].setVelocidade(0.2);
				zum[19].perseguir(player.x, player.y);
				player.atirar(janela, cena, teclado, zum[19]);
				zum[19].draw();
				zum[19].morrer(player);
				zum[19].atacar(player);
			
				
				player.energia(janela);
				
				player.draw();
				janela.update();

			}
	
	}
}
