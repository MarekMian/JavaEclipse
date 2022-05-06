package game;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sprite;
	public SpriteSheet(BufferedImage ss) {
		this.sprite=ss;
	}
	public BufferedImage grabImage(int x, int y, int wid, int hei) {
		BufferedImage img = sprite.getSubimage(x, y, wid, hei);
		return img;
	}

}
