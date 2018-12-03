package model;

import observer.AbstractObservable;
import observer.IObserver;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class ImageCustom extends AbstractObservable implements Serializable, IObserver {
	
	private Perspective[] tabPerspectives;
	private BufferedImage imageDeBase;
	private int indexCurrentPerspective = 0;

	public ImageCustom() { }
	
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

	public Perspective[] getPerspectives(){
		return tabPerspectives;
	}

	public void setTabPerspectives(Perspective[] tabPerspectives) {
		this.tabPerspectives = tabPerspectives;
	}

	public void setIndexCurrentPerspective(int indexCurrentPerspective) {
		this.indexCurrentPerspective = indexCurrentPerspective;
	}

	@Override
	public void update() {
		notifyObservers();
	}
}