package actions;

import java.awt.Point;
import java.awt.event.ActionEvent;

import commandes.CommandTranslate;
import model.Perspective;

public class ActionTranslate extends AbstractActionOnImage {

	private Point translation;
	
	public ActionTranslate(Perspective perspective, String name, Point translation) {
		super(perspective, name);
		this.translation = translation;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.manager.doCommand(new CommandTranslate(perspective, translation));
	}
}
