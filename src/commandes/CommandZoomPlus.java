package commandes;

import java.awt.Image;

import model.Perspective;

public class CommandZoomPlus extends AbstractCommand implements ICommandOnImage {

	public CommandZoomPlus(Perspective perspective) {
		super(perspective);
	}

	@Override
	public void undo() {
		perspective.updateZoom(-ZOOM_INCREMENT);
	}

	@Override
	public void execute() {
		perspective.updateZoom(ZOOM_INCREMENT);
	}
}
