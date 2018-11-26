package controller;

import java.awt.Image;

import model.Perspective;

public interface IActionOnImage {
	
	public void IActionOnImage(Perspective p);
	public void execute(Image i);
	public void undo();
}
