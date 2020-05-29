package com.Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;


public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -2784577147298149535L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	 private boolean running = false;
	 
	 private Random p;
	 private Storage storage;
	 private HUD hud;
	 private score licz;
	private static Enemy wrog;
	private static Player gracz;
	 
	 
	 
	public Game() {
		 storage = new Storage();
		 this.addKeyListener(new KeyInput(storage));
		 
	 new Window(HEIGHT, WIDTH, "GRA", this);
	 
	 
	 hud = new HUD();
	 licz = new score();
	 
	
	 p = new Random();
	 for(int i=0; i <1; i++) {
	 storage.addObject(new Player(WIDTH/2-32,HEIGHT/2-32, ID.Player));
	 storage.addObject(new Enemy(WIDTH/15-32,HEIGHT/5-32, ID.Enemy));
	 storage.addObject(new points(WIDTH/10-32,HEIGHT/10-32, ID.points));
	 	
	 
	 }
	 
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
	
	try {
		thread.join();
		running = false;
	}
catch(Exception z) {
	z.printStackTrace();
	}

	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >=1) {
				tick();
				delta--;
				}
			if(running)
				render();
				
			frames++;
			if(System.currentTimeMillis() - timer >1000) {
				timer += 1000;
				System.out.println("fps: " + frames);
				frames = 0;
				
			}
			
			}
		
		stop();
	}
	
	private void tick() {
		storage.tick();
		hud.tick();
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
	
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		storage.render(g);
		
		hud.render(g);
		licz.render(g);
		
		
		g.dispose();
		bs.show();
		
		
	}
	
	public void overlapp(ActionEvent e)
	{
		System.out.println("err1");
		double x1 = 0;
		double x2 = 0;
		double y1 = 0;
		double y2 = 0;
		System.out.println("err2");
		x1 = wrog.x = wrog.x + wrog.velX;
		y1 =wrog.y = wrog.y + wrog.velY;
		x2= gracz.x= gracz.x + gracz.velX;
		y2 =gracz.y = gracz.y + gracz.velY;
		System.out.println("err3");
		if(x1 == x2 && y1 == y2)
		{
			System.out.println("kolizja");
		}
		else
		{
			System.out.println("err");
		}
		
	}
	
	
	public static int clamp(int var, int min, int max) {
		if(var >= max )
			return var = max;
		else if (var <= min)
			return var = min;
		else 
			return var;
		
	}

	
	
	

	
	public static void main(String[] args) {
		
	
		
	new Game();
	
	
	
	
 }

	
}
