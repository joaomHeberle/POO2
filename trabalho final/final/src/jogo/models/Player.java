package jogo.models;





import java.awt.Color;
import java.awt.Font;

import dao.JogadorDAO;
import jogo.utils.ControleTiro;
import jplay.Keyboard;
import jplay.Scene;

import jplay.Window;

public class Player extends Ator {

	private double energia = 500;
	JogadorDAO jdao = new JogadorDAO();
	private int level = jdao.get(9).getNivel();
	private int experiencia = jdao.get(9).getExpNovoNivel();
	public double getEnergia() {
		return energia;
	}
	public int getLevel() {
		return level;
	}

	public Player(int x, int y) {
		super("src/recursos/sprite/nivel1.png", 3);


		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
	}

	ControleTiro tiros = new ControleTiro();

	public void atirar(Window janela, Scene cena, Keyboard teclado, Ator inimigo) {
		if (teclado.keyDown(Keyboard.SPACE_KEY)) {
			
			if(level==10) {
				tiros.adicionaTiro(x + 16, y + 4, direcao, cena);
				tiros.adicionaTiro(x + 24, y + 4, direcao, cena);
				tiros.adicionaTiro(x + 6, y + 4, direcao, cena);
			}else if(level >= 5 && level < 10){
				tiros.adicionaTiro(x + 9, y + 4, direcao, cena);
				tiros.adicionaTiro(x + 20, y + 4, direcao, cena);
			}else {
				tiros.adicionaTiro(x +15, y + 3, direcao, cena);
				
			}
		
		}
		tiros.run(inimigo);

	}

	public void controle(Window janela, Keyboard teclado) {
		if (level < 5) {
			setSequence(0, 1);
		}

		else if (level >= 5 && level < 10) {
			setSequence(1, 2);
		} else if (level == 10) {
			setSequence(2, 3);
		}
		if (teclado.keyDown(Keyboard.LEFT_KEY)) {
			if (this.x > 0)
				this.x -= velocidade;
			if (direcao != 1) {
				if (level < 5) {
					setSequence(0, 1);
				}

				else if (level >= 5 && level < 10) {
					setSequence(1, 2);
				} else if (level == 10) {
					setSequence(2, 3);
				}

				direcao = 1;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {

			if (this.x < janela.getWidth() - 30)
				this.x += velocidade;
			if (direcao != 2) {
				if (level < 5) {
					setSequence(0, 1);
				}

				else if (level >= 5 && level < 10) {
					setSequence(1, 2);
				} else if (level == 10) {
					setSequence(2, 3);
				}

				direcao = 2;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.UP_KEY)) {

			if (this.y > 0)
				this.y -= velocidade;
			if (direcao != 4) {
				if (level < 5) {
					setSequence(0, 1);
				}

				else if (level >= 5 && level < 10) {
					setSequence(1, 2);
				} else if (level == 10) {
					setSequence(2, 3);
				}

				direcao = 4;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.DOWN_KEY)) {

			if (this.y < janela.getHeight() - 30)
				this.y += velocidade;
			if (direcao != 5) {
				if (level < 5) {
					setSequence(0, 1);
				}

				else if (level >= 5 && level < 10) {
					setSequence(1, 2);
				} else if (level == 10) {
					setSequence(2, 3);
				}

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

	Font f = new Font("arial", Font.BOLD, 30);

	public void energia(Window janela) {
		janela.drawText("Energia: " + this.energia, 30, 30, Color.GREEN, f);
		janela.drawText("Nivel: " + this.level, 30, 80, Color.GREEN, f);

	}

	public void setEnergia(double energia) {
		this.energia = energia;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void aumentaNivel() {
		if(this.experiencia>=100) {
			this.level++;
			this.experiencia=0;
	
		}
	
	}
	public void ganhaXp() {
		this.experiencia+=10;
		System.out.println(this.experiencia);
		aumentaNivel();
	}

}
