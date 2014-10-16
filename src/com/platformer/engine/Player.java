package com.platformer.engine;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.Vector;

public class Player {
	public Point Position;
	public Dimension Size;
	public Point Velocity;
	public Color color;
	public GraphicsHandler g;
	public InputHandler i;
	public Container c;
	public int up, left, right;
	public Rectangle boundingBox;
	boolean jumping = false;
	boolean grounded = false;
	public int Jumps = 0;
	public int MaxJumps = 3;
	public Player(int x, int y, int width, int height){
		this.Position = new Point(x, y);
		this.Size = new Dimension(width, height);
		this.Velocity = new Point(0, 0);
		this.color = Color.GREEN;
		boundingBox = new Rectangle(Position, Size);
	}

	public void Init(GraphicsHandler g, InputHandler i, Container c){
		this.g = g;
		this.i = i;
		this.c = c;
	}

	public void InitControl(int u, int l, int r){
		this.up = u;
		this.left = l;
		this.right = r;
	}
	public void update(){
		this.boundingBox.x = this.Position.x;
		this.boundingBox.y = this.Position.y;
		this.Position.translate(this.Velocity.x, this.Velocity.y);
		if(this.Velocity.y<=0){
			this.Velocity.y += 2;
		}
		if(i.isKeyDown(up) && grounded){
			Jumps = 0;
			this.Velocity.y -= 30;
			Jumps = Jumps+1;

			jumping = true;
			grounded = false;
		}else if(!i.isKeyDown(up)){
			jumping = false;
		}
		if(i.isKeyDown(up) && this.Jumps<this.MaxJumps && !jumping){
			Jumps+=1;
			this.Velocity.y -= 30;
			jumping = true;
		}
		if(i.isKeyDown(left) && this.Velocity.x > -3){
			this.Velocity.x -= 1;
		}
		if(!i.isKeyDown(left) && this.Velocity.x < 0){
			this.Velocity.x += 1;
		}
		if(i.isKeyDown(right) && this.Velocity.x < 3){
			this.Velocity.x += 1;
		}
		if(!i.isKeyDown(right) && this.Velocity.x > 0){
			this.Velocity.x -= 1;
		}
	}

	public void draw(){
		g.stroke(Color.GREEN);
		g.fill(Color.GREEN);
		g.rect(this.Position.x, this.Position.y, this.Size.width, this.Size.height);
	}

	public void collide(Rectangle r){
		Rectangle predictedLoc = new Rectangle(this.Position.x+this.Velocity.x, this.Position.y+this.Velocity.y, this.Size.width, this.Size.height);
		if(predictedLoc.intersects(r)){
			Rectangle collision = predictedLoc.intersection(r);
			if(collision.width > collision.height){
				if(this.Velocity.y > 0){
					this.Position.y = r.y-this.Size.height-1;
					this.Jumps = 0;
				}else if(this.Velocity.y < 0){
					this.Position.y = r.y+r.height;
					this.Velocity.y = 0;
					
				}
			}else if(collision.width < collision.height){
				if(this.Velocity.x > 0 && this.Position.y < r.y+r.height && boundingBox.y + boundingBox.height > r.y+2){
		
					this.Position.x = r.x-this.Size.width;
				}else if(this.Velocity.x < 0 && this.Position.y < r.y+r.height && boundingBox.y + boundingBox.height > r.y+2){
					this.Position.x = r.x+r.width;
				}
			}
		}
		
		
	}
}