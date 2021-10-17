package Jogo;


import java.awt.event.KeyEvent;

import jplay.Keyboard;
import jplay.Scene;
import jplay.Sprite;
import jplay.Window;

public class Player extends Ator {
	static double energia=100;

	public Player(int x, int y) {
		super("src/recursos/sprite/zombie.png", 24);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
	}
	ControleTiro tiros = new ControleTiro();
public void atirar(Window janela,Scene cena, Keyboard teclado,Ator inimigo) {
	if(teclado.keyDown(Keyboard.SPACE_KEY)) {
		tiros.adicionaTiro(x,y,direcao,cena);
	}
	tiros.run(inimigo);
	
}
	public void controle(Window janela, Keyboard teclado) {

		if (teclado.keyDown(Keyboard.LEFT_KEY)) {
			if (this.x > 0)
				this.x -= velocidade;
			if (direcao != 1) {
				setSequence(6, 12);
				direcao = 1;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {

			if (this.x < janela.getWidth() - 30)
				this.x += velocidade;
			if (direcao != 2) {
				setSequence(12, 18);
				direcao = 2;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.UP_KEY)) {

			if (this.y > 0)
				this.y -= velocidade;
			if (direcao != 4) {
				setSequence(18, 24);
				direcao = 4;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.DOWN_KEY)) {

			if (this.y < janela.getHeight() - 30)
				this.y += velocidade;
			if (direcao != 5) {
				setSequence(0, 6);
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
