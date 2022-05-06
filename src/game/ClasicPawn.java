package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
//import java.awt.image.BufferedImage;

public class ClasicPawn extends GameObjects{
	//private BufferedImage ClasicPawn_image;

	public ClasicPawn(int x, int y, ID id) {
		super(x, y, id);
		velx=1;
		//SpriteSheet ss = new SpriteSheet(space.sprite_sheet);
		//ClasicPawn_image=ss.grabImage(57,25,11,8);
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 11, 8);
	}
	public void tick() {
		x += velx;
		y += vely;
		
	}
	
	public void render(Graphics g) {
		//g.drawImage(ClasicPawn_image, x, y, null);
		g.setColor(Color.white);
		if(space.r%(60/velx)<((30/velx)-1)) {
		g.fillRect(x+2, y, 1, 1);
		g.fillRect(x+8, y, 1, 1);
		g.fillRect(x+3, y+1, 1, 1);
		g.fillRect(x+7, y+1, 1, 1);
		g.fillRect(x+2, y+2, 7, 1);
		g.fillRect(x+1, y+3, 2, 1);
		g.fillRect(x+8, y+3, 2, 1);
		g.fillRect(x+4, y+3, 3, 1);
		g.fillRect(x, y+4, 11, 2);
		g.fillRect(x, y+6, 1, 1);
		g.fillRect(x+2, y+6, 1, 1);
		g.fillRect(x+9, y+6, 1, 1);
		g.fillRect(x+10, y+6, 1, 1);
		g.fillRect(x+3, y+7, 2, 1);
		g.fillRect(x+6, y+7, 2, 1);
		}
		else
		{
			g.fillRect(x, y+1, 1, 4);
			g.fillRect(x+10, y+1, 1, 4);
			g.fillRect(x+2, y, 1, 1);
			g.fillRect(x+8, y, 1, 1);
			g.fillRect(x+3, y+1, 1, 1);
			g.fillRect(x+7, y+1, 1, 1);
			g.fillRect(x+2, y+2, 7, 1);
			g.fillRect(x+1, y+3, 2, 1);
			g.fillRect(x+8, y+3, 2, 1);
			g.fillRect(x+4, y+3, 3, 1);
			g.fillRect(x+1, y+4, 9, 2);
			g.fillRect(x+2, y+6, 1, 1);
			g.fillRect(x+9, y+6, 1, 1);
			g.fillRect(x+1, y+7, 1, 1);
			g.fillRect(x+10, y+7, 1, 1);
		}
		
	}

}
