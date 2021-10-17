package Jogo;

import jplay.GameImage;
import jplay.Window;
import jplay.Keyboard;

public class TorreAtack {
	public static void main(String[] args) {

		Window janela = new Window(800, 600);
		GameImage plano = new GameImage("src/recursos/sprite/menu.png");

		Keyboard teclado = janela.getKeyboard();

		while (true) {
			plano.draw();
			janela.update();
			if (teclado.keyDown(Keyboard.ENTER_KEY)) {
				new Cenario1(janela);
			}
		}
	}

}
