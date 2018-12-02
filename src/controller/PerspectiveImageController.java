package controller;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import commandes.*;
import model.ImageCustom;

public class PerspectiveImageController implements MouseListener, MouseWheelListener, MouseMotionListener{
	
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
			CommandManager.getInstance().doCommand(new CommandZoomPlus(model.getCurrentPerspective()));
		} else {
			CommandManager.getInstance().doCommand(new CommandZoomMoins(model.getCurrentPerspective()));
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
		
		CommandManager.getInstance().doCommand(new CommandTranslate(model.getCurrentPerspective(), new Point(deltaX, deltaY)));
	}
}
