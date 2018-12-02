package commandes;

import java.awt.Image;

import model.Perspective;

public class CommandTranslateUp extends AbstractCommand implements ICommandOnImage {
	
	public CommandTranslateUp(Perspective perspective) {
		super(perspective);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}



	@Override
	public boolean execute() {
		if(perspective.translateUp(TRANSLATION_INCREMENT))
			return true;
		return false;
	}

}
