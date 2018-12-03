package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import observer.AbstractObservable;
import observer.IObserver;

public class ImageCustom extends AbstractObservable implements Serializable, IObserver {
	
	private Perspective[] tabPerspectives;
	private BufferedImage imageDeBase;
	private int indexCurrentPerspective = 0;
	
	public ImageCustom(BufferedImage imageDeBase){
		this.imageDeBase = imageDeBase;
		tabPerspectives = new Perspective[2];
		for(int i =0; i < tabPerspectives.length; i++) {
			tabPerspectives[i] = new Perspective(this);
		}
	}
	
	public BufferedImage getImage() {
		return imageDeBase;
	}
	
	public void setImage(BufferedImage img) {
		imageDeBase = img;
	}
	
	public int getCurrentPerspectiveIndex() {
		return indexCurrentPerspective;
	}
	
	public int getNbPerspectives() {
		return tabPerspectives.length;
	}
	
	public void changePerspective(int index){
		indexCurrentPerspective = index;
		update();
	}
	
	public Perspective getCurrentPerspective() {
		return tabPerspectives[indexCurrentPerspective];
	}

	@Override
	public void update() {
		notifyObservers();
	}
}