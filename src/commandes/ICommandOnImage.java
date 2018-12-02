package commandes;

import java.awt.Image;

import model.Perspective;

public interface ICommandOnImage {
	public boolean execute();
	public void undo();
}
