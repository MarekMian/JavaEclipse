package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
//import java.awt.image.BufferedImage;

public class player extends GameObjects{
	Objects objects;
	lives lives;
	//private BufferedImage player_image;

	public player(int x, int y, ID id, Objects objects) {
		super(x, y, id);
		this.objects=objects;
		//SpriteSheet ss = new SpriteSheet(space.sprite_sheet);
		//player_image=ss.grabImage(39,0,13,8);
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 13, 8);
	}
	public void tick() {
		x += velx;
		y += vely;
		if(x<=0) {
			x=1;
		}
		if(x>=space.WIDTH-26)
		{
			x=space.WIDTH-27;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y+4, 13, 4);
		g.fillRect(x+1, y+3, 11, 1);
		g.fillRect(x+5, y+1, 3, 2);
		g.fillRect(x+6, y, 1, 1);
		//g.drawImage(player_image, x, y, null);
	}
	

}
