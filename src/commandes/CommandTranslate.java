package commandes;

import java.awt.Point;

import model.ImageCustom;

public class CommandTranslate extends AbstractCommand implements ICommandOnImage{

	private Point translation;
	
	public CommandTranslate(ImageCustom imgCustom, Point translation) {
		super(imgCustom);
		this.translation = translation;
	}
	
	public void execute() {
		imgCustom.getCurrentPerspective().translate(translation.x, translation.y);
	}
	
	public void undo() {
		imgCustom.getCurrentPerspective().translate(-translation.x, -translation.y);
	}
}
