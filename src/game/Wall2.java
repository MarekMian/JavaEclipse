package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall2 extends GameObjects{

	public Wall2(int x, int y, ID id) {
		super(x, y, id);
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.setColor(Color.green);
		if(dmg==0) {
		g.fillRect(x, y, 6, 8);
		}
		else
		{
			g.fillRect(x+1, y, 2, 3);
			g.fillRect(x, y+3, 1, 1);
			g.fillRect(x+1, y+4, 1, 1);
			g.fillRect(x, y+5, 1, 1);
			g.fillRect(x+1, y+6, 1, 1);
			g.fillRect(x, y+7, 1, 1);
			g.fillRect(x+2, y+7, 1, 1);
			g.fillRect(x+4, y+7, 1, 1);
			g.fillRect(x+5, y+6, 1, 1);
			g.fillRect(x, y, 1, 1);
			g.fillRect(x+5, y, 1, 1);
			g.fillRect(x+5, y+2, 1, 1);
		}
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,6,8);
	}

}
