package commandes;

import java.awt.Image;

import model.Perspective;

public class CommandPaste extends AbstractCommand implements ICommandOnImage {

	public CommandPaste(Perspective perspective) {
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
