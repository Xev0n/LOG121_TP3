package model;

import observer.AbstractObservable;
import observer.IObserver;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * Classe de modèle d'image modifiable selon des perspectives
 * @author Alec
 *
 */
public class ImageCustom extends AbstractObservable implements Serializable, IObserver {
	
	private Perspective[] tabPerspectives;
	private BufferedImage imageDeBase;
	private int indexCurrentPerspective = 0;
	
	/**
	 * Instancie une ImageCustom selon une image de base
	 * @param imageDeBase Image de base
	 */
	public ImageCustom(BufferedImage imageDeBase){
		this.imageDeBase = imageDeBase;
		tabPerspectives = new Perspective[2];
		for(int i =0; i < tabPerspectives.length; i++) {
			tabPerspectives[i] = new Perspective(this);
		}
	}
	
	/**
	 * Obtient la BufferedImage associée
	 * @return image
	 */
	public BufferedImage getImage() {
		return imageDeBase;
	}
	
	/**
	 * Change l'image associée
	 * @param img
	 */
	public void setImage(BufferedImage img) {
		imageDeBase = img;
	}
	
	/**
	 * Obtient l'index de la perspective actuelle
	 * @return index
	 */
	public int getCurrentPerspectiveIndex() {
		return indexCurrentPerspective;
	}
	
	/**
	 * Obtient le nombre de perspectives 
	 * @return nombre perspectives
	 */
	public int getNbPerspectives() {
		return tabPerspectives.length;
	}
	
	/**
	 * Change la perspective
	 * @param index de la nouvelle perspective
	 */
	public void changePerspective(int index){
		indexCurrentPerspective = index;
		update();
	}
	
	/**
	 * Obtient la perspective courante
	 * @return perspective courante
	 */
	public Perspective getCurrentPerspective() {
		return tabPerspectives[indexCurrentPerspective];
	}

	/**
	 * Obtient toutes les perspectives
	 * @return tableau de perspectives
	 */
	public Perspective[] getPerspectives(){
		return tabPerspectives;
	}

	/**
	 * Change les perspectives
	 * @param tabPerspectives nouvelles perspectives
	 */
	public void setTabPerspectives(Perspective[] tabPerspectives) {
		this.tabPerspectives = tabPerspectives;
	}

	/**
	 * Change l'index de la perspective actuelle
	 * @param indexCurrentPerspective
	 */
	public void setIndexCurrentPerspective(int indexCurrentPerspective) {
		this.indexCurrentPerspective = indexCurrentPerspective;
	}

	@Override
	public void update() {
		notifyObservers();
	}
}