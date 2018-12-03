package commandes;

import model.ImageCustom;

public class CommandZoomPlus extends AbstractCommand implements ICommandOnImage {

	public CommandZoomPlus(ImageCustom imgCustom) {
		super(imgCustom);
	}

	@Override
	public void undo() {
		imgCustom.getCurrentPerspective().updateZoom(-ZOOM_INCREMENT);
	}

	@Override
	public void execute() {
		imgCustom.getCurrentPerspective().updateZoom(ZOOM_INCREMENT);
	}
}
