package commandes;

import java.awt.Image;

import model.Perspective;

public class CommandChangePerspective extends AbstractCommand implements ICommandOnImage {

	public CommandChangePerspective(Perspective perspective) {
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
