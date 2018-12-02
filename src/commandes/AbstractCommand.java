package commandes;

import model.Perspective;

public abstract class AbstractCommand {
	
	protected static Perspective perspective;
	protected static double ZOOM_INCREMENT = 0.1;
	
	public AbstractCommand(Perspective perspective) {
		this.perspective = perspective;
	}
}
