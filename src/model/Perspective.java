package model;

import javax.imageio.ImageIO;

import observer.AbstractObservable;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Perspective extends AbstractObservable{
	private String iconPath;
	private double zoomLevel;
	private Point position;
	private int width = 500;
	private int height = 400;


	public Perspective(){
		iconPath="src/ressources/img.jpg";
		position = new Point();

	}
	
	public BufferedImage getImage(){
		BufferedImage img= null;
		try {
			img = ImageIO.read(new File(iconPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	public void setIconPath(String path){
		this.iconPath=path;

	}
	public void translate(int x, int y){
		
	}
	
	public void setZoom(double zoom){
		
	}

	public String[] getPerspectivesNames(){
		String[] names = {"Perspective 1", "Perspective 2"};
		return names;
	}

	public boolean deZoomer(double increment) {
		if(width * height == 0)
			return false;
		this.width -= increment;
		this.height -= increment;
		position.x += increment / 2;
		position.y += increment / 2;
		notifier();
		return true;
	}

	public boolean zoomer(double increment) {
		if(width * height == 0)
			return false;
		this.width += increment;
		this.height += increment;
		position.x -= increment / 2;
		position.y -= increment / 2;
		notifier();
		return true;
	}

	public int getWidth() {
		return this.width ;
	}

	public int getHeight() {
		return this.height;
	}

	public int getY() {
		return position.y;
	}

	public int getX() {
		return position.x;
	}

	public boolean translateDown(int increment) {
		position.y += increment;
		notifier();
		return true;
	}

	public boolean translateUp(int increment) {
		position.y -= increment;
		notifier();
		return true;
	}

	public boolean translateRight(int increment) {
		position.x += increment;
		notifier();
		return true;
	}

	public boolean translateLeft(int increment) {
		position.x -= increment;
		notifier();
		return true;
	}
}
