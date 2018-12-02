package commandes;

import java.awt.Image;

import model.Perspective;

public class CommandZoomPlus extends AbstractCommand implements ICommandOnImage {


	private static double ZOOM_INCREMENT = 20;

	public CommandZoomPlus(Perspective perspective) {
		super(perspective);
	}


	@Override
	public void undo() {
		// TODO Auto-generated method stub
	}


	@Override
	public boolean execute() {
		if(perspective.zoomer(ZOOM_INCREMENT))
			return true;
		return false;
	}
}
