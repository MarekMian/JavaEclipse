package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ClasicTank extends GameObjects{

	public ClasicTank(int x, int y, ID id) {
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
		g.fillRect(x+4, y, 4, 1);
		g.fillRect(x+1, y+1, 10, 1);
		g.fillRect(x, y+2, 12, 1);
		g.fillRect(x, y+3, 3, 1);
		g.fillRect(x+5, y+3, 2, 1);
		g.fillRect(x+9, y+3, 3, 1);
		g.fillRect(x, y+4, 12, 1);
		g.fillRect(x+2, y+5, 3, 1);
		g.fillRect(x+7, y+5, 3, 1);
		g.fillRect(x+1, y+6, 2, 1);
		g.fillRect(x+5, y+6, 2, 1);
		g.fillRect(x+9, y+6, 2, 1);
		g.fillRect(x+2, y+7, 2, 1);
		g.fillRect(x+8, y+7, 2, 1);
		}
		else
		{
		g.fillRect(x+4, y, 4, 1);
		g.fillRect(x+1, y+1, 10, 1);
		g.fillRect(x, y+2, 12, 1);
		g.fillRect(x, y+3, 3, 1);
		g.fillRect(x+5, y+3, 2, 1);
		g.fillRect(x+9, y+3, 3, 1);
		g.fillRect(x, y+4, 12, 1);
		g.fillRect(x+3, y+5, 2, 1);
		g.fillRect(x+7, y+5, 2, 1);
		g.fillRect(x+2, y+6, 2, 1);
		g.fillRect(x+5, y+6, 2, 1);
		g.fillRect(x+8, y+6, 2, 1);
		g.fillRect(x, y+7, 2, 1);
		g.fillRect(x+10, y+7, 2, 1);
		}
		
	}

}

