package game;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObjects {
	protected int x, y;
	int dmg=0;
	protected ID id;
	protected int velx, vely;
	public GameObjects(int x, int y, ID id) {
		this.x=x;
		this.y=y;
		this.id=id;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public void setx(int x) {
		this.x=x;
	}
	public void sety(int y) {
		this.y=y;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public void setID(ID id) {
		this.id=id;
	}
	public ID getID() {
		return id;
	}
	public void setvelx(int velx) {
		this.velx=velx;
	}
	public void setvely(int vely) {
		this.vely=vely;
	}
	public int getvelx() {
		return velx;
	}
	public int getvoly() {
		return vely;
	}
	
}
