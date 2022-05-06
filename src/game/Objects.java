package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Objects {
	LinkedList<GameObjects> object = new LinkedList<GameObjects>();
	public void tick() {
		for(int i=0; i<object.size(); i++)
		{
			GameObjects tempObject = object.get(i);
			tempObject.tick();
		}
		
	}
	public void render(Graphics g) {
		for(int i=0; i<object.size(); i++)
		{
			GameObjects tempObject = object.get(i);
			tempObject.render(g);
		}
		
	}
	public void addObject(GameObjects object) {
		this.object.add(object);
	}
	public void removeObject(GameObjects object) {
		this.object.remove(object);
	}

}
