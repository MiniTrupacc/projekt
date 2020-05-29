package com.Main;

import java.awt.Color;
import java.awt.Graphics;

public class points extends GameObject 
{

	public points(int x, int y, ID id) {
		super(x, y, id);
		 
		velX = 2;
		velY = 2;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >=Game.HEIGHT - 32)  velY *= -1;
		if(x <= 0 || x >=Game.WIDTH - 32)  velX *= -1;
	}


	public void render(Graphics g) {
	
		g.setColor(Color.magenta);
		g.fillRect(x, y, 10, 10);
		
	}
	
	

}
