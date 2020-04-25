package com.Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -2784577147298149535L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	 private boolean running = false;
	 
	 private Random p;
	 private Storage storage;
	 private HUD hud;
	 
	public Game() {
		 storage = new Storage();
		 this.addKeyListener(new KeyInput(storage));
		 
		 
	 new Window(HEIGHT, WIDTH, "projekt", this);
	 
	 
	 hud = new HUD();
	 
	
	 p = new Random();
	 for(int i=0; i <1; i++) {
	 storage.addObject(new Player(WIDTH/2-32,HEIGHT/2-32, ID.Player));
	 storage.addObject(new Enemy(WIDTH/2-32,HEIGHT/2-32, ID.Enemy));
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
	
		g.setColor(Color.pink);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		storage.render(g);
		
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	

	
	public static int clamp(int var, int min, int max) {
		if(var >= max )
			return var = max;
		else if (var <= min)
			return var = min;
		else 
			return var;
	}
	
	if(HEALTH==0)
	{
		System.exit(1);
	}
	
	public static void main(String[] args) {
	
	new Game();
	
 }
}
