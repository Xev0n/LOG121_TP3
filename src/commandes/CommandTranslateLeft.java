package commandes;

import static commandes.AbstractCommand.TRANSLATION_INCREMENT;

import java.awt.Image;

import model.Perspective;
import model.Perspective.enuTranslationDirection;

public class CommandTranslateLeft extends AbstractCommand implements ICommandOnImage {
	
	public CommandTranslateLeft(Perspective perspective) {
		super(perspective);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void undo() {
		perspective.translate(TRANSLATION_INCREMENT, enuTranslationDirection.HORIZONTAL);
	}

	@Override
	public void execute() {
		perspective.translate(-TRANSLATION_INCREMENT, enuTranslationDirection.HORIZONTAL);
	}

}
