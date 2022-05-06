package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Option extends GameObjects{
	int z;

	public Option(int x, int y, ID id, int z) {
		super(x, y, id);
		this.z=z;
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		if(space.red<3) {
		g.setColor(Color.blue);
		switch(z) {
		case 0:{
			g.drawString("extra mode", x-20, y);
			break;
		}
		case 1:{
			g.drawString("clasic mode", x-22, y);
			break;
		}
		case 2:{
			g.drawString("exit", x, y);
			break;
		}
		}
		if(z==space.red) {
			g.fillRect(x-6, y, 13*2, 8*2);
		}
		else
		{
			g.fillRect(x, y, 13, 8);
		}
		}
		if(z==4) {
			g.drawString("not yet implemented", x-22, y);
		}
	}
	public Rectangle getBounds() {
		return null;
	}

}
