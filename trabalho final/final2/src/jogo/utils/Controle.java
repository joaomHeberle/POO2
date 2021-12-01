package jogo.utils;

import jogo.models.Zumbie;
import jplay.GameObject;
import jplay.TileInfo;

public class Controle {
	
		public boolean colisao(GameObject obj, TileInfo tile){
			if((tile.id!=0)&&obj.collided(tile)&& obj instanceof Zumbie) {
				
		
				return true;
			}else if((tile.id<57||tile.id==64)&&obj.collided(tile)&& !(obj instanceof Zumbie)) {
				return true;
			}
			
			return false;
			
		}
		
	

}
