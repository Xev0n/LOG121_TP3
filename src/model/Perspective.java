package model;

import observer.AbstractObservable;

import java.awt.*;
import java.io.Serializable;

public class Perspective extends AbstractObservable implements Serializable {
	
	/**
	 * Enum that represents the different direction of a possible translation.
	 * @author Alec
	 */

	//private static final long serialVersionUID = -1496543845304703683L;
	public enum enuTranslationDirection {
		HORIZONTAL, VERTICAL
	}
	
	private double zoomLevel = 1.0;
	private Point translation = new Point();
	
	public double getZoomLevel() {
		return zoomLevel;
	}
	
	public Point getTranslation() {
		return translation;
	}
	
	public Perspective(ImageCustom imageCustom) {
		addObserver(imageCustom);
	}
	
	public void translate(int dx, int dy){
		translation.x += dx;
		translation.y += dy;
		notifyObservers();
	}
	
	public void updateZoom(double zoomIncrement){
		zoomLevel += zoomIncrement;
		notifyObservers();
	}
}
