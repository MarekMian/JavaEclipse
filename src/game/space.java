package game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
//import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class space extends Canvas implements Runnable{
	private static final long serialVersionUID = -7181952559531504587L;
	public static final int WIDTH=224;
	public static final int HEIGHT=256;
	private Thread thread;
	private boolean running=false;
	private Objects objects;
	private lives lives;
	public static int kill=0;
	int score=0;
	public static int red=0;
	public static int r=0;
	public static int b=0;
	public static int kkey=0;
	Random rnd = new Random();
	//public static BufferedImage sprite_sheet;
	
	public space(){
		//BufferedImageLoader loader= new BufferedImageLoader();
		//sprite_sheet=loader.loadImage("/sheetSpaceInvaders.png");
		objects = new Objects();
		this.addKeyListener(new KeyInput(objects));
		new window(WIDTH, HEIGHT, "Space Invaders", this);
		lives = new lives();
		objects.addObject(new player(99,200, ID.Player, objects));
		objects.addObject(new Option(space.WIDTH/2-6, 25, ID.Option, 0));
		objects.addObject(new Option(space.WIDTH/2-6, 50, ID.Option, 1));
		objects.addObject(new Option(space.WIDTH/2-6, 75, ID.Option, 2));
	}
	private void lvlstart() {
		for(int wa=0; wa<4; wa++) {
			objects.addObject(new Wall(12+(wa*54), 169, ID.Wall));
			objects.addObject(new Wall1(18+(wa*54), 169, ID.Wall1));
			objects.addObject(new Wall2(24+(wa*54), 169, ID.Wall2));
			objects.addObject(new Wall3(30+(wa*54), 169, ID.Wall3));
			objects.addObject(new Wall4(12+(wa*54), 177, ID.Wall4));
			objects.addObject(new Wall5(18+(wa*54), 177, ID.Wall5));
			objects.addObject(new Wall6(24+(wa*54), 177, ID.Wall6));
			objects.addObject(new Wall7(30+(wa*54), 177, ID.Wall7));
		}
		for(int ia=0; ia<11; ia++)
		{
		objects.addObject(new ClasicSquid(36+(ia*15),40, ID.ClasicSquid));
		}
		for(int ic=0; ic<11; ic++)
		{
		objects.addObject(new ClasicPawn(36+(ic*15),56, ID.ClasicPawn));
		}
		for(int it=0; it<11; it++)
		{
		objects.addObject(new ClasicPawn(36+(it*15),72, ID.ClasicPawn));
		}
		for(int ik=0; ik<11; ik++)
		{
		objects.addObject(new ClasicTank(36+(ik*15),88, ID.ClasicTank));
		}
		for(int irk=0; irk<11; irk++)
		{
		objects.addObject(new ClasicTank(36+(irk*15),104, ID.ClasicTank));
		}
	}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running=true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running=false;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		this.requestFocus();
		long lastTime=System.nanoTime();
		double amountOfTicks=60.0;
		double ns=1000000000/amountOfTicks;
		double delta=0;
		long timer =System.currentTimeMillis();
		int frames=0;
		while(running) {
			long now=System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime=now;
			while(delta>=1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			if(System.currentTimeMillis()-timer>1000) {
				timer +=1000;
				//System.out.println("FPS: "+frames);
				frames=0;
			}
			
		}
		stop();
	}
	private void tick() {
		if(red==1&&kkey==2) {
			red=3;
			lvlstart();
		}
		if(red==0&&kkey==1) {
			red=4;
			objects.addObject(new Option(70,20, ID.Option, 4));
		}
		if(red==4) {
			objects.tick();
			lives.tick();
			despawn();
		}
		if(red==3) {
		objects.tick();
		lives.tick();
		corner();
		collision();
		hit();
		friendlyfire();
		r++;
		shoot();
		kill();
		boom();
		despawn();
		}
		
	}
	private void despawn() {
		for(int i=0; i<objects.object.size(); i++) {
			GameObjects tempObject=objects.object.get(i);
			if((tempObject.getID()==ID.Bullet&&tempObject.gety()<=10)||(tempObject.getID()==ID.Shot&&tempObject.gety()>=210))
			{
				objects.removeObject(tempObject);
				b--;
			}
		}
	}
	private void boom() {
		for(int i=0; i<objects.object.size(); i++) {
			GameObjects tempObject=objects.object.get(i);
			if(tempObject.getID()==ID.Shot||tempObject.getID()==ID.ClasicPawn||tempObject.getID()==ID.ClasicSquid||tempObject.getID()==ID.ClasicTank)
			{
				for(int j=0; j<objects.object.size(); j++) {
					GameObjects tempObjectt=objects.object.get(j);
					if(tempObjectt.getID()==ID.Wall||tempObjectt.getID()==ID.Wall1||tempObjectt.getID()==ID.Wall2||tempObjectt.getID()==ID.Wall3||tempObjectt.getID()==ID.Wall4||tempObjectt.getID()==ID.Wall5||tempObjectt.getID()==ID.Wall6||tempObjectt.getID()==ID.Wall7) {
						if(tempObjectt.getBounds().intersects(tempObject.getBounds())) {
							objects.removeObject(tempObject);
							if(tempObjectt.dmg==1) {
							objects.removeObject(tempObjectt);
							}
							else {
								tempObjectt.dmg++;
							}
							if(tempObject.getID()==ID.Shot) {
							b--;
							}
						}
					}
				}
			}
		}
	}
	private void kill() {
		for(int i=0; i<objects.object.size(); i++) {
			GameObjects tempObject=objects.object.get(i);
			if(tempObject.getID()==ID.Shot)
			{
				for(int j=0; j<objects.object.size(); j++) {
					GameObjects tempObjectt=objects.object.get(j);
					if(tempObjectt.getID()==ID.Player) {
						if(tempObjectt.getBounds().intersects(tempObject.getBounds())) {
							objects.removeObject(tempObject);
							b--;
							lives.hp-=1;
							if(lives.hp==(-1))
							{
								System.exit(1);
							}
						}
					}
				}
			}
		}
	}
	private void shoot() {
		int kr=1;
		int kk=99;
		for(int i=0; i<objects.object.size(); i++) {
			GameObjects tempObject=objects.object.get(i);
			if(tempObject.getID()==ID.ClasicPawn||tempObject.getID()==ID.ClasicSquid||tempObject.getID()==ID.ClasicTank) {
				kr=i;
				break;
			}
		}
		for(int i=objects.object.size()-1; i>1; i--) {
			GameObjects tempObject=objects.object.get(i);
			if(tempObject.getID()==ID.ClasicPawn||tempObject.getID()==ID.ClasicSquid||tempObject.getID()==ID.ClasicTank) {
				kk=i;
				break;
			}
		}
		if(r%50==3&&(kk-kr)>12) {
			for(int i=kk-(rnd.nextInt(11)); i>=kr; i--) {
				GameObjects tempObject=objects.object.get(i);
				if(tempObject.getID()==ID.ClasicPawn||tempObject.getID()==ID.ClasicSquid||tempObject.getID()==ID.ClasicTank)
				{
					objects.addObject(new Shot(tempObject.getx()+6, tempObject.gety()+8, ID.Shot));
					b++;
					break;
				}
			}
		}
		else {
			if(r%50==3&&(kk-kr)>1) {
				for(int i=kk-(rnd.nextInt(kk-kr)); i>=kr; i--) {
					GameObjects tempObject=objects.object.get(i);
					if(tempObject.getID()==ID.ClasicPawn||tempObject.getID()==ID.ClasicSquid||tempObject.getID()==ID.ClasicTank)
					{
						objects.addObject(new Shot(tempObject.getx()+6, tempObject.gety()+8, ID.Shot));
						b++;
						break;
					}
				}
			}
			else {
				if(r%50==3) {
					for(int i=kk; i>=kr; i--) {
						GameObjects tempObject=objects.object.get(i);
						if(tempObject.getID()==ID.ClasicPawn||tempObject.getID()==ID.ClasicSquid||tempObject.getID()==ID.ClasicTank)
						{
							objects.addObject(new Shot(tempObject.getx()+6, tempObject.gety()+8, ID.Shot));
							b++;
							break;
						}
					}
				}
			}
		}
	}
	private void friendlyfire() {
		for(int i=0; i<objects.object.size(); i++) {
			GameObjects tempObject=objects.object.get(i);
			if(tempObject.getID()==ID.Bullet)
			{
				for(int j=0; j<objects.object.size(); j++) {
					GameObjects tempObjectt=objects.object.get(j);
					if(tempObjectt.getID()==ID.Wall||tempObjectt.getID()==ID.Wall1||tempObjectt.getID()==ID.Wall2||tempObjectt.getID()==ID.Wall3||tempObjectt.getID()==ID.Wall4||tempObjectt.getID()==ID.Wall5||tempObjectt.getID()==ID.Wall6||tempObjectt.getID()==ID.Wall7) {
						if(tempObjectt.getBounds().intersects(tempObject.getBounds())) {
							objects.removeObject(tempObject);
							b--;
						}
					}
				}
			}
		}
	}
	private void hit() {
		for(int i=0; i<objects.object.size(); i++) {
			GameObjects tempObject=objects.object.get(i);
			if(tempObject.getID()==ID.ClasicPawn||tempObject.getID()==ID.ClasicSquid||tempObject.getID()==ID.ClasicTank)
			{
				for(int j=0; j<objects.object.size(); j++) {
					GameObjects tempObjectt=objects.object.get(j);
					if(tempObjectt.getID()==ID.Bullet) {
						if(tempObjectt.getBounds().intersects(tempObject.getBounds())) {
							objects.removeObject(tempObject);
							objects.removeObject(tempObjectt);
							kill++;
							b--;
							if(tempObject.getID()==ID.ClasicPawn) {
							score+=20;
							}
							else {
								if(tempObject.getID()==ID.ClasicSquid) {
									score+=30;
								}
								else {
									score+=10;
								}
							}
							if(kill%55==16) {
								for(int ii=0; ii<objects.object.size(); ii++) {
									GameObjects tempObjecti=objects.object.get(ii);
									if(tempObjecti.getID()==ID.ClasicPawn||tempObjecti.getID()==ID.ClasicSquid||tempObjecti.getID()==ID.ClasicTank)
									{
										tempObjecti.setvelx(2);
									}
								}
							}
							if(kill%55==25) {
								for(int ii=0; ii<objects.object.size(); ii++) {
									GameObjects tempObjecti=objects.object.get(ii);
									if(tempObjecti.getID()==ID.ClasicPawn||tempObjecti.getID()==ID.ClasicSquid||tempObjecti.getID()==ID.ClasicTank)
									{
										tempObjecti.setvelx(3);
									}
								}
							}
							if(kill%55==41) {
								for(int ii=0; ii<objects.object.size(); ii++) {
									GameObjects tempObjecti=objects.object.get(ii);
									if(tempObjecti.getID()==ID.ClasicPawn||tempObjecti.getID()==ID.ClasicSquid||tempObjecti.getID()==ID.ClasicTank)
									{
										tempObjecti.setvelx(4);
									}
								}
							}
							if(kill%55==50) {
								for(int ii=0; ii<objects.object.size(); ii++) {
									GameObjects tempObjecti=objects.object.get(ii);
									if(tempObjecti.getID()==ID.ClasicPawn||tempObjecti.getID()==ID.ClasicSquid||tempObjecti.getID()==ID.ClasicTank)
									{
										tempObjecti.setvelx(5);
									}
								}
							}
							if(kill%55==0) {
								lvlstart();
							}
						}
					}
				}
			}
		}
	}
	private void collision() {
		for(int i=0; i<objects.object.size(); i++) {
			GameObjects tempObject=objects.object.get(i);
			if(tempObject.getID()==ID.ClasicPawn||tempObject.getID()==ID.ClasicSquid||tempObject.getID()==ID.ClasicTank)
			{
				for(int j=0; j<objects.object.size(); j++) {
					GameObjects tempObjectt=objects.object.get(j);
					if(tempObjectt.getID()==ID.Player) {
						if(tempObjectt.getBounds().intersects(tempObject.getBounds())) {
							lives.hp-=1;
							objects.removeObject(tempObject);
							if(lives.hp==-1)
							{
								System.exit(1);
							}
						}
					}
				}
			}
		}
	}
	private void corner()
	{
		for(int i=0; i<objects.object.size(); i++) {
			GameObjects tempObject = objects.object.get(i);
			if(tempObject.getID()==ID.ClasicPawn||tempObject.getID()==ID.ClasicSquid||tempObject.getID()==ID.ClasicTank) {
				if(tempObject.getx()<=0) {
					for(int j=0; j<objects.object.size(); j++) {
						GameObjects tempObjects = objects.object.get(j);
						if(tempObjects.getID()==ID.ClasicPawn||tempObjects.getID()==ID.ClasicSquid||tempObjects.getID()==ID.ClasicTank) {
					tempObjects.setvelx(tempObjects.getvelx()*(-1));
					tempObjects.sety(tempObjects.gety()+1);
					tempObjects.setx(tempObjects.getx()+5);
						}
					}
			}
				if(tempObject.getx()>=space.WIDTH-26) {
					for(int j=0; j<objects.object.size(); j++) {
						GameObjects tempObjects = objects.object.get(j);
						if(tempObjects.getID()==ID.ClasicPawn||tempObjects.getID()==ID.ClasicSquid||tempObjects.getID()==ID.ClasicTank) {
					tempObjects.setvelx(tempObjects.getvelx()*(-1));
					tempObjects.sety(tempObjects.gety()+1);
					tempObjects.setx(tempObjects.getx()-5);
						}
					}
				}
			}
		}
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.white);
		g.drawString("score"+score, 15, 10);
		objects.render(g);
		lives.render(g);
		g.dispose();
		bs.show();
	}
	public static void main(String args[]) {
			new space();
		
	}

}
