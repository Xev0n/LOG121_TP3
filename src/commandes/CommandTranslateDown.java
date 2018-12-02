package commandes;

import static commandes.AbstractCommand.TRANSLATION_INCREMENT;

import java.awt.Image;

import model.Perspective;

public class CommandTranslateDown extends AbstractCommand implements ICommandOnImage {
	
	public CommandTranslateDown(Perspective perspective) {
		super(perspective);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean execute() {
		if(perspective.translateDown(TRANSLATION_INCREMENT))
			return true;
		return false;
	}

}
