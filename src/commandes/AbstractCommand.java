package commandes;

import model.ImageCustom;
import model.Perspective;

public abstract class AbstractCommand {
	
	protected static ImageCustom imgCustom;
	protected static double ZOOM_INCREMENT = 0.1;
	
	public AbstractCommand(ImageCustom imgCustom) {
		this.imgCustom = imgCustom;
	}
}
