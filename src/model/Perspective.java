package model;

import java.awt.Point;

import observer.AbstractObservable;

public class Perspective extends AbstractObservable {
	
	/**
	 * Enum that represents the different direction of a possible translation.
	 * @author Alec
	 */
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
	
	public void translate(int value, enuTranslationDirection direction){
		switch (direction) {
		case HORIZONTAL:
			translation.x += value;
			break;
		case VERTICAL:
			translation.y += value;
			break;
		}
		notifyObservers();
	}
	
	public void updateZoom(double zoomIncrement){
		zoomLevel += zoomIncrement;
		notifyObservers();
	}
}
