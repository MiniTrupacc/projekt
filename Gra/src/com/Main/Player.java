package com.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {

	Random p = new Random();
	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	}
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0,Game.WIDTH -32);
		y = Game.clamp(y, 0,Game.HEIGHT -53);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);			//obiekt gracza i jego wygląd
		g.fillRect(x, y, 25, 25);
	}
	
	
	
}
