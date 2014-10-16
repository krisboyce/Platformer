package com.platformer.engine;

import java.awt.Color;
import java.awt.Graphics;

public class GraphicsHandler {
	public Graphics g;
	public Color fill;
	public Color stroke;
	public Color background;
	public int strokeWeight = 1;
	
	public GraphicsHandler(Graphics g){
		this.g = g;
	}
	
	public Color background(){
		return this.background;
	}
	
	public void background(Color c){
		background = c;
	}
	
	public void background(int r, int g, int b){
		background = new Color(r, g, b);
	}
	
	public void background(int v){
		background = new Color(v);
	}
	
	public Color fill(){
		return this.fill;
	}
	
	public void fill(Color c){
		fill = c;
	}
	
	public void fill(int r, int g, int b){
		fill = new Color(r, g, b);
	}
	
	public void fill(int v){
		fill = new Color(v);
	}
	
	public Color stroke(){
		return this.stroke;
	}
	
	public void stroke(Color c){
		stroke = c;
	}
	
	public void stroke(int r, int g, int b){
		stroke = new Color(r, g, b);
	}
	
	public void stroke(int v){
		stroke = new Color(v);
	}
	
	public void ellipse(int x, int y, int width, int height){
		g.setColor(stroke);
		g.drawOval(x, y, width, height);
		
		g.setColor(fill);
		g.fillOval(x, y, width, height);
	}
	
	public void rect(int x, int y, int width, int height){
		g.setColor(stroke);
		g.drawRect(x, y, width, height);
		g.setColor(fill);
		g.fillRect(x, y, width, height);
	}
	
	public void drawBackground(int width, int height){
		g.setColor(background);
		g.fillRect(0, 0, width, height);
		g.setColor(fill);
	}
}
