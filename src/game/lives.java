package game;

import java.awt.Color;
import java.awt.Graphics;

public class lives{
	int hp=2;
	public void tick() {
		
	}
	public void render(Graphics g){
		g.setColor(Color.white);
		g.drawString("lives", space.WIDTH/2+15, 10);
		g.setColor(Color.green);
		for(int i=0; i<hp; i++) {
			//g.fillRect(space.WIDTH/2+47+18*i, 1, 13, 8);
			g.fillRect(space.WIDTH/2+47+18*i, 5, 13, 4);
			g.fillRect(space.WIDTH/2+47+18*i+1, 4, 11, 1);
			g.fillRect(space.WIDTH/2+47+18*i+5, 2, 3, 2);
			g.fillRect(space.WIDTH/2+47+18*i+6, 1, 1, 1);
	}

}
}
