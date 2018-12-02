package commandes;

import java.awt.Image;

import model.Perspective;

public class CommandZoomMoins extends AbstractCommand implements ICommandOnImage {

	public CommandZoomMoins(Perspective perspective) {
		super(perspective);
		// TODO Auto-generated constructor stub
	}


	private static double ZOOM_INCREMENT = 20;
	

	@Override
	public void undo() {
		// TODO Auto-generated method stub
	}


	@Override
	public boolean execute() {
		if(perspective.deZoomer(ZOOM_INCREMENT))
			return true;
		return false;
	}
}
