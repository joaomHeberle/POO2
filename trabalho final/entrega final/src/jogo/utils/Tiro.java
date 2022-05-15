package jogo.utils;

import jplay.Sprite;

public class Tiro extends Sprite {

	public static final int LEFT = 1, RIGHT = 2, STOP = 3, UP = 4, DOWN = 5;
	protected static final int VELOCIDADE_TIRO =1;
	protected int caminho = STOP;
	protected boolean movendo = false;
	protected int direcao = 3;

	public Tiro(double x, double y, int caminho) {
		super("src/recursos/sprite/bala.png", 4);
		this.caminho = caminho;
		this.x = x;
		this.y = y;
	}

	public void mover() {
		if (caminho == LEFT) {
			this.y -= VELOCIDADE_TIRO;
			if (direcao != 4) {
				setSequence(3, 4);
			}
			movendo = true;
		}
		if (caminho == RIGHT) {
			this.y -= VELOCIDADE_TIRO;
			if (direcao != 4) {
				setSequence(3, 4);
			}
			movendo = true;
		}
		if (caminho == UP) {
			this.y -= VELOCIDADE_TIRO;
			if (direcao != 4) {
				setSequence(3, 4);
			}
			movendo = true;
		}
		if (caminho == DOWN || caminho == STOP) {
			this.y -= VELOCIDADE_TIRO;
			if (direcao != 4) {
				setSequence(3, 4);
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
