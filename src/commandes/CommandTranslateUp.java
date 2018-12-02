package commandes;

import java.awt.Image;

import model.Perspective;
import model.Perspective.enuTranslationDirection;

public class CommandTranslateUp extends AbstractCommand implements ICommandOnImage {
	
	public CommandTranslateUp(Perspective perspective) {
		super(perspective);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void undo() {
		perspective.translate(TRANSLATION_INCREMENT, enuTranslationDirection.VERTICAL);

	}

	@Override
	public void execute() {
		perspective.translate(-TRANSLATION_INCREMENT, enuTranslationDirection.VERTICAL);
	}

}
