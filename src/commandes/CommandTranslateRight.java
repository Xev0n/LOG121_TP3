package commandes;

import java.awt.Image;

import model.Perspective;
import model.Perspective.enuTranslationDirection;

public class CommandTranslateRight extends AbstractCommand implements ICommandOnImage {
	
	public CommandTranslateRight(Perspective perspective) {
		super(perspective);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void undo() {
		perspective.translate(-TRANSLATION_INCREMENT, enuTranslationDirection.HORIZONTAL);

	}

	@Override
	public void execute() {
		perspective.translate(TRANSLATION_INCREMENT, enuTranslationDirection.HORIZONTAL);
	}

}
