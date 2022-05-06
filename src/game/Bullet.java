package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObjects{

	public Bullet(int x, int y, ID id) {
		super(x, y, id);
		vely=-1;
	}
	public void tick() {
		y+=vely;
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 1, 8);
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,1,8);
	}

}
