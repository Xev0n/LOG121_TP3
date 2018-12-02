package commandes;

import static commandes.AbstractCommand.TRANSLATION_INCREMENT;

import java.awt.Image;

import model.Perspective;

public class CommandTranslateLeft extends AbstractCommand implements ICommandOnImage {
	
	public CommandTranslateLeft(Perspective perspective) {
		super(perspective);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean execute() {
		if(perspective.translateLeft(TRANSLATION_INCREMENT))
			return true;
		return false;
	}

}
