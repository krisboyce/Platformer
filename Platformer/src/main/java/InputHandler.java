package main.java;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputHandler implements KeyListener, MouseListener,
		MouseMotionListener {
	boolean[] Keys = new boolean[256];
	
	public InputHandler(Component c) {
		c.addKeyListener(this);
		c.addMouseListener(this);
		c.addMouseMotionListener(this);
	}
	int buttonDown = 0;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		pmouseX = e.getX();
		pmouseY = e.getY();
		this.buttonDown = e.getButton();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	boolean mousePressed = false;

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		pmouseX = e.getX();
		pmouseY = e.getY();
		mousePressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mousePressed = false;

	}

	public boolean isKeyDown(int keyCode) {
		if (keyCode > 0 && keyCode < 256) {
			return Keys[keyCode];
		}
		return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
			Keys[e.getKeyCode()] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
			Keys[e.getKeyCode()] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public int pmouseX, pmouseY;

	@Override
	public void mouseDragged(MouseEvent e) {
		pmouseX = e.getX();
		pmouseY = e.getY();
	}

	public int mouseX, mouseY;

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	boolean isMouseAt(int x, int y) {
		if (mouseX == x && mouseY == y) {
			return true;
		} else {
			return false;
		}
	}

	boolean isMouseAt(Point p) {
		Point mousePos = new Point(mouseX, mouseY);
		if (mousePos == p) {
			return true;
		} else {
			return false;
		}
	}

}
