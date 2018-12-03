package commandes;

import model.ImageCustom;

public class CommandZoomMoins extends AbstractCommand implements ICommandOnImage {

	public CommandZoomMoins(ImageCustom imgCustom) {
		super(imgCustom);
	}
	
	@Override
	public void undo() {
		imgCustom.getCurrentPerspective().updateZoom(ZOOM_INCREMENT);
	}

	@Override
	public void execute() {
		imgCustom.getCurrentPerspective().updateZoom(-ZOOM_INCREMENT);
	}
}
