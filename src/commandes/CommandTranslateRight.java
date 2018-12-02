package commandes;

import java.awt.Image;

import model.Perspective;

public class CommandTranslateRight extends AbstractCommand implements ICommandOnImage {
	
	public CommandTranslateRight(Perspective perspective) {
		super(perspective);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean execute() {
		if(perspective.translateRight(TRANSLATION_INCREMENT))
			return true;
		return false;
	}

}
