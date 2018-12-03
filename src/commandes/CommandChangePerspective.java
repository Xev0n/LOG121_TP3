package commandes;

import model.ImageCustom;

public class CommandChangePerspective extends AbstractCommand implements ICommandOnImage {

	private int index;
	private int previousIndex;
	
	public CommandChangePerspective(ImageCustom imgCustom, int index) {
		super(imgCustom);
		this.index = index;
		previousIndex = imgCustom.getCurrentPerspectiveIndex();
	}

	@Override
	public void undo() {
		imgCustom.changePerspective(previousIndex);
	}

	@Override
	public void execute() {
		CommandManager.getInstance().resetUndoStack();
		imgCustom.changePerspective(index);
	}

}
