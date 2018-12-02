package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import observer.AbstractObservable;
import observer.IObserver;

public class ImageCustom extends AbstractObservable implements Serializable, IObserver {
	
	private Perspective currentPerspective;
	private Perspective[] tabPerspectives;
	private BufferedImage imageDeBase;
	
	public ImageCustom(BufferedImage imageDeBase){
		this.imageDeBase = imageDeBase;
		tabPerspectives = new Perspective[2];
		for(int i =0; i < tabPerspectives.length; i++) {
			tabPerspectives[i] = new Perspective(this);
		}
		currentPerspective = tabPerspectives[0];
	}
	
	public BufferedImage getImage() {
		return imageDeBase;
	}
	
	public void setImage(BufferedImage img) {
		imageDeBase = img;
	}
	
	public int getNbPerspectives() {
		return tabPerspectives.length;
	}
	
	public void changePerspective(int index){
		currentPerspective = tabPerspectives[index];
	}
	
	public Perspective getCurrentPerspective() {
		return currentPerspective;
	}

	@Override
	public void update() {
		notifyObservers();
	}
}