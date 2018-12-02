package commandes;

import model.Perspective;

public class AbstractCommand {
	
	protected static Perspective perspective;
	protected static int TRANSLATION_INCREMENT = 10;
	protected static double ZOOM_INCREMENT = 0.1;
	
	public AbstractCommand(Perspective perspective) {
		this.perspective = perspective;
	}

}
