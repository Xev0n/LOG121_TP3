package actions;

import javax.swing.AbstractAction;

import commandes.CommandManager;
import model.ImageCustom;

/**
 * Classe permettant de centraliser l'attribut imgCustom ainsi que le manager
 * n�cessaires pour les actions *
 */
public abstract class AbstractActionOnImage extends AbstractAction{
	/**
	 * Contient l'image et les perspectives � modifier 
	 */
	protected ImageCustom imgCustom;
	
	/**
	 * 
	 * @param imgCustom image a modifier
	 * @param name le nom � afficher du composant pour lequel l'action est associ�
	 */
	public AbstractActionOnImage(ImageCustom imgCustom, String name) {
		super(name);
		this.imgCustom = imgCustom;
	}
	/**
	 * Le manager de commandes
	 */
	protected final static CommandManager manager = CommandManager.getInstance();
}
