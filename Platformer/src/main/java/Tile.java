package main.java;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Tile {
	boolean solid = true;
	public TileType type;
	public BufferedImage texture = null;
	GraphicsHandler g;
	public Point Position;
	public Rectangle boundingBox;
	public Tile(int x, int y, TileType type) {
		Position = new Point(x * 32, y * 32);
		this.boundingBox = new Rectangle(this.Position.x, this.Position.y, 32, 32);
		this.type = type;
	}

	public void Init(GraphicsHandler g) {
		this.g = g;
		switch (this.type) {
		case BRICK:
			try {
				InputStream url = this.getClass().getResourceAsStream("/main/resources/images/brick.png");
				texture = ImageIO.read(url);
				System.out.println("File Loaded");
			} catch (IOException e) {
				System.out.println("File not found");

			}
			break;
		default:
			break;
		}
	}

	public void update() {
		this.boundingBox = new Rectangle(this.Position.x, this.Position.y, 32,
				32);
	}

	public void draw(double interpolation) {
		g.stroke(Color.WHITE);
		g.fill(Color.BLUE);
		g.rect(this.Position.x, this.Position.y, 32, 32);
		g.g.drawImage(texture, this.Position.x, this.Position.y, 32, 32, null);
	}

}
