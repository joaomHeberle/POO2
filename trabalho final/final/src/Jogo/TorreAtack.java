package jogo;

import jogo.views.Cenario2;
import jplay.GameImage;
import jplay.Window;
import jplay.Keyboard;

public class TorreAtack {
	public static void main(String[] args) {

		Window janela = new Window(800, 600);
		GameImage plano = new GameImage("src/recursos/cenarios/menu.png");

		Keyboard teclado = janela.getKeyboard();

		while (true) {
			plano.draw();
			janela.update();
			if (teclado.keyDown(Keyboard.ENTER_KEY)) {
				new Cenario2(janela);
			}
		}
	}

}
