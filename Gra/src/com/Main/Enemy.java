package com.Main;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject {

	public Enemy(int x, int y, ID id) {
		super(x, y, id);
		 
		velX = 3;
		velY = 3;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >=Game.HEIGHT - 32)  velY *= -1;
		if(x <= 0 || x >=Game.WIDTH - 32)  velX *= -1;
	}


	public void render(Graphics g) {
	
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
	
	

}
