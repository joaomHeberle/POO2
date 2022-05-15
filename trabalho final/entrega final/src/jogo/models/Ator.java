package jogo.models;

import java.awt.Point;
import java.util.Vector;

import jogo.utils.Controle;
import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

public class Ator extends Sprite {
	

	Controle controle = new Controle();
	protected double velocidade = 1;
	protected int direcao = 3;
	protected boolean movendo = false;
	public double energia=1000;
	public boolean tocou=false;
	public Ator(String fileName, int numFrames) {
		super(fileName, numFrames);
		
	}


	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public boolean isMovendo() {
		return movendo;
	}

	public void setMovendo(boolean movendo) {
		this.movendo = movendo;
	}

	public double getEnergia() {
		return energia;
	}

	public void setEnergia(double energia) {
		this.energia = energia;
	}

	public boolean isTocou() {
		return tocou;
	}

	public void setTocou(boolean tocou) {
		this.tocou = tocou;
	}

	public void caminho(Scene cena) {
		Point min = new Point((int)this.x,(int)this.y);
		Point max = new Point((int)this.x+this.width,(int)this.y+this.height);
		
		Vector<?>tiles=cena.getTilesFromPosition(min, max);
		
		for (int i = 0; i < tiles.size(); i++) {
			TileInfo tile = (TileInfo) tiles.elementAt(i);
		
			if(controle.colisao(this, tile)==true) {
				tocou=true;
				if(colisaoVertical(this, tile)) {
				if(tile.y+tile.height-2 < this.y) {
					this.y = tile.y+tile.height;
				}
				else if(tile.y>this.y+this.height -2) {
					this.y = tile.y-this.height;
				}
			}
				if(colisaoHorizontal(this, tile)) {
					if(tile.x>this.x + this.width -2) {
						this.x = tile.x - this.width;
					}else if(tile.x+tile.width -2 < this.x){
						this.x = tile.x + tile.width;
					}
				}
			}
		}
		
		
	}

	private boolean colisaoVertical(GameObject obj, GameObject obj2) {
		if (obj2.x + obj2.width <= obj.x)
			return false;
		if (obj.x + obj.width <= obj2.x)
			return false;
		return true;
	}

	private boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
		if (obj2.y + obj2.height <= obj.y)
			return false;
		if (obj.y + obj.height <= obj2.y)
			return false;
		return true;
	}
}
