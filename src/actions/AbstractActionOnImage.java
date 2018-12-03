package actions;

import javax.swing.AbstractAction;

import commandes.CommandManager;
import model.ImageCustom;

public abstract class AbstractActionOnImage extends AbstractAction{
	
	protected ImageCustom imgCustom;
	
	public AbstractActionOnImage(ImageCustom imgCustom, String name) {
		super(name);
		this.imgCustom = imgCustom;
	}
	protected final static CommandManager manager = CommandManager.getInstance();
}
