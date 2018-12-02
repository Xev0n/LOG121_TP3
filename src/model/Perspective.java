package model;

import javax.imageio.ImageIO;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Perspective extends Observable{
	private String iconPath;
	private double zoomLevel;
	private Point position;
	private List<Observer> observers;


	public Perspective(){
		iconPath="src/ressources/img.jpg";

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
}
