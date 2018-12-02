package commandes;

import static commandes.AbstractCommand.TRANSLATION_INCREMENT;

import java.awt.Image;

import model.Perspective;
import model.Perspective.enuTranslationDirection;

public class CommandTranslateDown extends AbstractCommand implements ICommandOnImage {
	
	public CommandTranslateDown(Perspective perspective) {
		super(perspective);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void undo() {
		perspective.translate(-TRANSLATION_INCREMENT, enuTranslationDirection.VERTICAL);

	}
	
	@Override
	public void execute() {
		perspective.translate(TRANSLATION_INCREMENT, enuTranslationDirection.VERTICAL);
	}

}
