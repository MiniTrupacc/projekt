package com.Main;

import java.awt.Color;
import java.awt.Graphics;

public class score {

	public static int score = 0;
	
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawString(score + " pkt", 550, 40);
	}
	
	
}
