package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Shot extends GameObjects{

	public Shot(int x, int y, ID id) {
		super(x, y, id);
		vely=1;
	}
	public void tick() {
		y+=vely;
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 3, 6);
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,3,6);
	}

}