package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ClasicSquid extends GameObjects{

	public ClasicSquid(int x, int y, ID id) {
		super(x, y, id);
		velx=1;
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 11, 8);
	}
	public void tick() {
		x += velx;
		y += vely;
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		if(space.r%(60/velx)<((30/velx)-1)) {
		g.fillRect(x+3, y, 2, 1);
		g.fillRect(x+2, y+1, 4, 1);
		g.fillRect(x+1, y+2, 6, 1);
		g.fillRect(x, y+3, 2, 1);
		g.fillRect(x+3, y+3, 2, 1);
		g.fillRect(x+6, y+3, 2, 1);
		g.fillRect(x, y+4, 8, 1);
		g.fillRect(x+1, y+5, 1, 1);
		g.fillRect(x+3, y+5, 2, 1);
		g.fillRect(x+6, y+5, 1, 1);
		g.fillRect(x, y+6, 1, 1);
		g.fillRect(x+7, y+6, 1, 1);
		g.fillRect(x+1, y+7, 1, 1);
		g.fillRect(x+6, y+7, 1, 1);
		}
		else
		{
			g.fillRect(x+3, y, 2, 1);
			g.fillRect(x+2, y+1, 4, 1);
			g.fillRect(x+1, y+2, 6, 1);
			g.fillRect(x, y+3, 2, 1);
			g.fillRect(x+3, y+3, 2, 1);
			g.fillRect(x+6, y+3, 2, 1);
			g.fillRect(x, y+4, 8, 1);
			g.fillRect(x+2, y+5, 1, 1);
			g.fillRect(x+5, y+5, 1, 1);
			g.fillRect(x+1, y+6, 1, 1);
			g.fillRect(x+3, y+6, 2, 1);
			g.fillRect(x+6, y+6, 1, 1);
			g.fillRect(x, y+7, 1, 1);
			g.fillRect(x+2, y+7, 1, 1);
			g.fillRect(x+5, y+7, 1, 1);
			g.fillRect(x+7, y+7, 1, 1);
		}
		
	}

}
