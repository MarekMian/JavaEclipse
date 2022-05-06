package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall6 extends GameObjects{

	public Wall6(int x, int y, ID id) {
		super(x, y, id);
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.setColor(Color.green);
		if(dmg==0) {
			g.fillRect(x+2, y, 4, 1);
			g.fillRect(x+3, y+1, 3, 1);
			g.fillRect(x+4, y+2, 2, 1);
			g.fillRect(x+5, y+3, 1, 1);
			}
			else {
				g.fillRect(x+2, y, 1, 1);
				g.fillRect(x+5, y, 1, 1);
				g.fillRect(x+5, y+2, 1, 1);
			}
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,6,9);
	}

}