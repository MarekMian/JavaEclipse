package game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput  extends KeyAdapter{
	private Objects objects;
	public KeyInput(Objects objects) {
		this.objects=objects;
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i=0; i<objects.object.size(); i++) {
			GameObjects tempObject = objects.object.get(i);
			if(tempObject.getID()==ID.Player) {
				switch (key) {
					case KeyEvent.VK_LEFT: {
						tempObject.setvelx(-1);
						break;
				}
					case KeyEvent.VK_RIGHT: {
						tempObject.setvelx(1);
						break;
					}
			}
			}
		}
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i=0; i<objects.object.size(); i++) {
			GameObjects tempObject = objects.object.get(i);
			if(tempObject.getID()==ID.Player) {
				switch (key) {
					case KeyEvent.VK_LEFT: {
						tempObject.setvelx(0);
						break;
				}
					case KeyEvent.VK_RIGHT: {
						tempObject.setvelx(0);;
						break;
					}
					 case KeyEvent.VK_SPACE:{
						
						objects.addObject(new Bullet(tempObject.getx()+7,tempObject.gety()-8, ID.Bullet));
						space.b+=1;
						break;
					}
					 case KeyEvent.VK_ENTER:{
						 if(space.red==0)
						 {
							space.kkey=1;
							break;
						 }
						 if(space.red==1)
						 {
							 space.kkey=2;
							 break;
						 }
						 if(space.red==2) {
							 System.exit(1);
						 }
						}
					 case KeyEvent.VK_UP:{
						 if(space.red>0&&space.red<=2)
						 {
							space.red--;
							break;
						 }
						}
					 case KeyEvent.VK_DOWN:{
						 if(space.red>=0&&space.red<2)
						 {
							space.red++;
							break;
						 }
						}
			}
			}
		}
	}

}
