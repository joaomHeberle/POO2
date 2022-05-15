package jogo.models;

import jogo.utils.MissaoUtil;
import jogo.views.Cenario1;
import jplay.Window;

public class Zumbie extends Ator {
	MissaoUtil mu = new MissaoUtil();
	private double ataque=1;
	private boolean dir=true;
	private boolean desc=false;
	private int cont=0;
	private static int a=0;
	private int id=0;
	private static int quantidade;
	public Zumbie(int x, int y) {
		super("src/recursos/sprite/enemy1.png", 1);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.velocidade = 0.1;
	}
	public Zumbie(int x, int y, int id) {
		super("src/recursos/sprite/enemy1.png", 1);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.velocidade = 0.1;
		this.id = id;
		quantidade = mu.retornaQuantidade(id);
		
	}
	public void mover(Window janela){
				
			
			
				if(this.x>=700 && dir) {
				
						moveTo(this.x,this.y+=1,velocidade);
					if(cont-10>Cenario1.tam) {
						dir=false;
						desc=true;
						cont=0;
						if(this.velocidade<0.5)
						this.velocidade+=0.1;
						
					}
						
					cont++;
					
					
					
				}if(desc) {
					moveTo(this.x-1,this.y,velocidade);
					if(this.x<=20) {
						dir=true;
						desc=false;
					}

				}else {
					moveTo(this.x+1,this.y,velocidade);
					movendo = true;
					
				}
		

		if (movendo)

		{
			update();
			movendo = false;
		}

	}
	public void perseguir(double x, double y) {
		if (this.x > x && this.y <= y + 50 && this.y >= y - 50) {
			moveTo(x, y, velocidade);
			if (direcao != 1) {
				setSequence(0, 1);
				direcao = 1;
			}
			movendo = true;
		} else if (this.x < x && this.y <= y + 50 && this.y >= y - 50) {
			moveTo(x, y, velocidade);
			if (direcao != 2) {
				setSequence(0, 1);
				direcao = 2;
			}
			movendo = true;
		} else if (this.y < y) {
			moveTo(x, y, velocidade);
			if (direcao != 5) {
				setSequence(0, 1);
				direcao = 5;
			}
			movendo = true;
		} else if (this.y > y) {
			moveTo(x, y, velocidade);
			if (direcao != 4) {
				setSequence(0, 1);
				direcao = 4;
			}
			movendo = true;
		}
		if (movendo)

		{
			update();
			movendo = false;
		}
	}

	public void morrer(Player player,int i) {
		
		if(this.energia<=0 ) {
			
		var ver =true;
			if(ver) {
		
			Zumbie.a+=1;
			this.velocidade=0;
			this.ataque=0;
			this.direcao=0;
			this.movendo=false;
			this.x = 1_000_000;
			this.energia=1;
			player.ganhaXp(110);
			if(a==quantidade&&quantidade!=0) {
		
				player.ganhaXp(1000);
				var x = mu.retornaId(player.getId());
				mu.completouMissao(player.getId(),x);
			}
			if(a==i) {
				player.atualizaCampos(player);
				System.exit(0);
			}
			
			
			}
		}
		
		
	}
	public void atacar (Player player) {
		double energy = player.getEnergia();
		if(this.collided(player)) {
			
			energy-=this.ataque;
			player.setEnergia(energy);
		}
		if(energy<=0) {
			player.atualizaCampos(player);
			System.exit(0);
		}
		
	}
	

}
