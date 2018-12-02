package commandes;

import java.awt.Point;

import model.Perspective;

public class CommandTranslate extends AbstractCommand implements ICommandOnImage{

	private Point translation;
	
	public CommandTranslate(Perspective perspective, Point translation) {
		super(perspective);
		this.translation = translation;
	}
	
	public void execute() {
		perspective.translate(translation.x, translation.y);
	}
	
	public void undo() {
		perspective.translate(-translation.x, -translation.y);
	}
}
