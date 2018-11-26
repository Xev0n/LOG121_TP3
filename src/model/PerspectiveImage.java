package model;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PerspectiveImage extends Observable{
	private String iconPath;
	private double zoomLevel;
	private Point position;
	private List<Observer> observers;
	
	public BufferedImage getImage(){
		return null;
	}
	
	public void translate(int x, int y){
		
	}
	
	public void setZoom(double zoom){
		
	}
}
