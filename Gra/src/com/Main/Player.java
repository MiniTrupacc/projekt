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
		
	}
	
	public void render(Graphics g) {
		if(id ==ID.Player)		g.setColor(Color.blue);
		g.fillRect(x, y, 25, 25);
	}
}
