package jogo.models;

import jplay.Keyboard;
import jplay.Window;

public class Player2 extends Ator{

	public Player2(int x, int y) {
		super("src/recursos/sprite/player2.png", 12);


		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.velocidade=0.5;
	}
	
	
	public void controle(Window janela, Keyboard teclado) {

		if (teclado.keyDown(Keyboard.LEFT_KEY)) {
			if (this.x > 0)
				this.x -= velocidade;
			if (direcao != 1) {
				setSequence(0, 3);
				direcao = 1;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {

			if (this.x < janela.getWidth() - 30)
				this.x += velocidade;
			if (direcao != 2) {
				setSequence(9, 12);

				direcao = 2;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.UP_KEY)) {

			if (this.y > 0)
				this.y -= velocidade;
			if (direcao != 4) {
				setSequence(6, 9);
				direcao = 4;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.DOWN_KEY)) {
			
			if (this.y < janela.getHeight() - 30)
				this.y += velocidade;
			if (direcao != 5) {
				setSequence(3, 6);
				direcao = 5;
			}
			movendo = true;
		}

		if (movendo)

		{
			update();
			movendo = false;
		}
	}


}
