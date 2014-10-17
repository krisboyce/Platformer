package com.platformer.engine;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

public class Tile {
	boolean solid = true;
	GraphicsHandler g;
	public Point Position;
	public Rectangle boundingBox;
	public Tile(int x, int y){
		Position = new Point(x, y);
		this.boundingBox = new Rectangle(x*46, y*32, 64, 64);
	}
	
	public void Init(GraphicsHandler g){
		this.g = g;
	}
	
	public void update(){
	}
	
	public void draw(){
		g.stroke(Color.BLUE);
		g.fill(Color.BLUE);
		g.rect(this.Position.x*46, this.Position.y*32, 64, 64);
	}
	
	
}
