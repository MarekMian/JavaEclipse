package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall5 extends GameObjects{

	public Wall5(int x, int y, ID id) {
		super(x, y, id);
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.setColor(Color.green);
		if(dmg==0) {
			g.fillRect(x, y, 4, 1);
			g.fillRect(x, y+1, 3, 1);
			g.fillRect(x, y+2, 2, 1);
			g.fillRect(x, y+3, 1, 1);
			}
			else {
				g.fillRect(x, y, 3, 1);
				g.fillRect(x+1, y+1, 1, 1);
				g.fillRect(x, y+3, 1, 1);
			}
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,6,9);
	}

}