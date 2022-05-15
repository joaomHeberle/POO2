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
	private int id;
	private int level; 
	private int experiencia;
	public double getEnergia() {
		return energia;
	}
	public int getLevel() {
		return level;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEnergia(double energia) {
		this.energia = energia;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	public Player(int x, int y, int id) {
		super("src/recursos/sprite/nivel1.png", 3);

	
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.level = geraNivel(id);
		this.experiencia = geraExp(id);
		this.id = id;
	}

	private int geraNivel(int id) {
		JogadorDAO jdao = new JogadorDAO();
		
		return jdao.get(id).getNivel();
	}
	private int geraExp(int id) {
JogadorDAO jdao = new JogadorDAO();
		
		return jdao.get(id).getExpNovoNivel();
	}
	
	ControleTiro tiros = new ControleTiro();

	public void atirar(Window janela, Scene cena, Keyboard teclado, Ator inimigo) {
		if (teclado.keyDown(Keyboard.SPACE_KEY)) {
			
			if(this.level>=10) {
				tiros.adicionaTiro(x + 16, y + 4, direcao, cena);
				tiros.adicionaTiro(x + 24, y + 4, direcao, cena);
				tiros.adicionaTiro(x + 6, y + 4, direcao, cena);
			}else if(this.level >= 5 && this.level < 10){
				tiros.adicionaTiro(x + 9, y + 4, direcao, cena);
				tiros.adicionaTiro(x + 20, y + 4, direcao, cena);
			}else {
				tiros.adicionaTiro(x +15, y + 3, direcao, cena);
				
			}
		
		}
		tiros.run(inimigo);

	}

	public void controle(Window janela, Keyboard teclado) {
		if (this.level < 5) {
			setSequence(0, 1);
		}

		else if (this.level >= 5 && this.level < 10) {
			setSequence(1, 2);
		} else if (this.level >= 10) {
			setSequence(2, 3);
		}
		if (teclado.keyDown(Keyboard.LEFT_KEY)) {
			if (this.x > 0)
				this.x -= velocidade;
			if (direcao != 1) {
				if (this.level < 5) {
					setSequence(0, 1);
				}

				else if (this.level >= 5 && this.level < 10) {
					setSequence(1, 2);
				} else if (this.level >= 10) {
					setSequence(2, 3);
				}

				direcao = 1;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {

			if (this.x < janela.getWidth() - 30)
				this.x += velocidade;
			if (direcao != 2) {
				if (this.level < 5) {
					setSequence(0, 1);
				}

				else if (this.level >= 5 && this.level < 10) {
					setSequence(1, 2);
				} else if (this.level >= 10) {
					setSequence(2, 3);
				}

				direcao = 2;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.UP_KEY)) {

			if (this.y > 0)
				this.y -= velocidade;
			if (direcao != 4) {
				if (this.level < 5) {
					setSequence(0, 1);
				}

				else if (this.level >= 5 && this.level < 10) {
					setSequence(1, 2);
				} else if (this.level >= 10) {
					setSequence(2, 3);
				}

				direcao = 4;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.DOWN_KEY)) {

			if (this.y < janela.getHeight() - 30)
				this.y += velocidade;
			if (direcao != 5) {
				if (this.level < 5) {
					setSequence(0, 1);
				}

				else if (this.level >= 5 && this.level < 10) {
					setSequence(1, 2);
				} else if (this.level >= 10) {
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
		janela.drawText("Energia: " + this.energia, 10, 30, Color.GREEN, f);
		janela.drawText("Nivel: " + this.level, 10, 80, Color.GREEN, f);
		janela.drawText("Exp: " + this.experiencia, 10, 130, Color.GREEN, f);
	}


	public void aumentaNivel() {
		while(true) {
		if(this.experiencia>=100) {
			this.level++;
			this.experiencia-=100;
			
		}else {
			break;
		}
		}
	}
	public void ganhaXp(int i) {
		this.experiencia+=i;

		aumentaNivel();
	}
	
	public void atualizaCampos(Player play) {
		JogadorDAO jdao = new JogadorDAO();
		jdao.updateNivelExp(play);
		
		
	}


}
