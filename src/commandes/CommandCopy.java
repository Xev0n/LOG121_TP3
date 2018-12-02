package commandes;

import java.awt.Image;

import model.Perspective;

public class CommandCopy extends AbstractCommand implements ICommandOnImage {

	public CommandCopy(Perspective perspective) {
		super(perspective);
		// TODO Auto-generated constructor stub
	}



	private static Perspective perspective;



	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}



	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return false;
	}

}
