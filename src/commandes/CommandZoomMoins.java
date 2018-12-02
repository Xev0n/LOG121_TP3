package commandes;

import java.awt.Image;

import model.Perspective;

public class CommandZoomMoins extends AbstractCommand implements ICommandOnImage {

	public CommandZoomMoins(Perspective perspective) {
		super(perspective);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void undo() {
		perspective.updateZoom(ZOOM_INCREMENT);
	}

	@Override
	public void execute() {
		perspective.updateZoom(-ZOOM_INCREMENT);
	}
}
