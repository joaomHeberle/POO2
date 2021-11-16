package jogo.views;

import java.awt.Point;
import java.util.Vector;

import jogo.models.Player;
import jogo.models.Player2;
import jplay.GameObject;
import jplay.Scene;
import jplay.TileInfo;

public abstract class Cenario {
	
	protected boolean tileCollision(int value, Player player, Scene cena) {
		Point min = new Point((int)player.x,(int)player.y);
		Point max = new Point((int)(player.x+player.width),(int)(player.y+player.height));
		Vector<?> tiles = cena.getTilesFromPosition(min, max);
		for(int i =0;i<tiles.size(); i++) {
			TileInfo tile = (TileInfo) tiles.elementAt(i);
			if(tileCollision(player,tile,value)==true) {
				return true;
			}
		}
		return false;
	}
	protected boolean tileCollision(int value, Player2 player, Scene cena) {
		Point min = new Point((int)player.x,(int)player.y);
		Point max = new Point((int)(player.x+player.width+20),(int)(player.y+player.height));
		Vector<?> tiles = cena.getTilesFromPosition(min, max);
		for(int i =0;i<tiles.size(); i++) {
			TileInfo tile = (TileInfo) tiles.elementAt(i);
			if(tileCollision(player,tile,value)==true) {
				return true;
			}
		}
		return false;
	}

	private boolean tileCollision(GameObject obj, TileInfo tile, int value) {
		if((tile.id==value)&& obj.collided(tile)) {
			return true;
		}
		
		
		return false;
	}
	
	
	

}
