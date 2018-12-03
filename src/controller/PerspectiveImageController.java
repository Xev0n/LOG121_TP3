package controller;

import commandes.CommandManager;
import commandes.CommandSave;
import commandes.CommandTranslate;
import commandes.CommandZoomMoins;
import commandes.CommandZoomPlus;
import model.ImageCustom;
import model.Memento;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class PerspectiveImageController implements MouseListener, MouseWheelListener, MouseMotionListener, KeyListener{
	
	private ImageCustom model;
	private Point initialMousePosition;
	
	public PerspectiveImageController(ImageCustom model) {
		this.model = model;
	}

	@Override
	public void mouseDragged(MouseEvent e) { }

	@Override
	public void mouseMoved(MouseEvent e) { }

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation() < 1) {
			System.out.println(model.getCurrentPerspective().getZoomLevel());
			CommandManager.getInstance().doCommand(new CommandZoomPlus(model));
		} else {
			CommandManager.getInstance().doCommand(new CommandZoomMoins(model));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) {
		initialMousePosition = new Point(e.getX(), e.getY());
		e.getComponent().setCursor(new Cursor(Cursor.MOVE_CURSOR));
	}

	@Override
	public void mouseReleased(MouseEvent e) { 
		e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
		int deltaX = e.getX() - initialMousePosition.x;
		int deltaY = e.getY() - initialMousePosition.y;
		
		CommandManager.getInstance().doCommand(new CommandTranslate(model, new Point(deltaX, deltaY)));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			CommandManager.getInstance().undo();
		}
		
		if((e.getKeyCode() == KeyEvent.VK_Y) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			CommandManager.getInstance().redo();
		}
		
		if((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			CommandSave commande = new CommandSave(model);
			commande.execute();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void keyTyped(KeyEvent e) { }
}
