package com.Main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Storage {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		
		for(int i=0; i <object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		
		for(int i=0; i <object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
	}
  }
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObjet(GameObject object) {
		this.object.remove(object);
	}
	
}