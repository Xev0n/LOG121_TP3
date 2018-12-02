package command;

import java.awt.Image;

import model.Perspective;

public interface IActionOnImage {
	public void execute(Image i);
	public void undo();
}
