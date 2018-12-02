package actions;

import javax.swing.AbstractAction;

import commandes.CommandManager;
import model.Perspective;

public abstract class AbstractActionOnImage extends AbstractAction{
	
	protected Perspective perspective;
	
	public AbstractActionOnImage(Perspective perspective, String name) {
		super(name);
		this.perspective = perspective;
	}
	protected final static CommandManager manager = CommandManager.getInstance();
}
