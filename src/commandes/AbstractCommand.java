package commandes;

import model.ImageCustom;

/**
 * Classe abstraite qui contient l'attribut de l'image à manipuler par chacune des commandes
 *
 */
public abstract class AbstractCommand {
	
	protected static ImageCustom imgCustom;
	protected static double ZOOM_INCREMENT = 0.1;
	
	public AbstractCommand(ImageCustom imgCustom) {
		this.imgCustom = imgCustom;
	}
}
