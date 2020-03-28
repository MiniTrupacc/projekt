package com.Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {
	
	private Storage storage;
	
	private boolean W = false;
	private boolean S = false;
	private boolean A = false;
	private boolean D = false;

	
	
	public KeyInput(Storage storage) {
		this.storage = storage;
	}
	

	

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
	
		
		for( int i =0; i< storage.object.size(); i++) {
			GameObject tempObject = storage.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				 //sterowanie WSAD dla gracza
				
				if(key == KeyEvent.VK_W) tempObject.setVelY(-5);
				if(key == KeyEvent.VK_S) tempObject.setVelY(5);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-5);
				if(key == KeyEvent.VK_D) tempObject.setVelX(5);
			}
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);

	}

	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
	
		
		for( int i =0; i< storage.object.size(); i++) {
			GameObject tempObject = storage.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				 //sterowanie WSAD dla gracza
				
				if(key == KeyEvent.VK_W) tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);
				if(key == KeyEvent.VK_A) tempObject.setVelX(0);
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
			}
		}
		
	}

}
