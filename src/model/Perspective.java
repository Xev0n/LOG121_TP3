package model;

import observer.AbstractObservable;

import java.awt.*;
import java.io.Serializable;

/**
 * 
 * @author Alec
 *
 */
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
	
	/**
	 * Obtient le niveau de zoom
	 * @return retourne le zoom
	 */
	public double getZoomLevel() {
		return zoomLevel;
	}
	
	/**
	 * Obtient la translation
	 * @return translation
	 */
	public Point getTranslation() {
		return translation;
	}
	
	/**
	 * Construit la perspective
	 * @param imageCustom image
	 */
	public Perspective(ImageCustom imageCustom) {
		addObserver(imageCustom);
	}
	
	/**
	 * Effectue une translation
	 * @param dx mouvement selon les x
	 * @param dy mouvement selon les y
	 */
	public void translate(int dx, int dy){
		translation.x += dx;
		translation.y += dy;
		notifyObservers();
	}
	
	/**
	 * Met à jour l'incrément de zoom
	 * @param zoomIncrement incrément
	 */
	public void updateZoom(double zoomIncrement){
		zoomLevel += zoomIncrement;
		notifyObservers();
	}
}
