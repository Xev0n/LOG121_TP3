package actions;

import java.awt.event.ActionEvent;

import commandes.CommandTranslateDown;
import commandes.CommandTranslateUp;
import commandes.CommandZoomPlus;
import model.Perspective;

public class ActionZoomPlus extends AbstractActionOnImage{


	public ActionZoomPlus(Perspective perspective, String name) {
		super(perspective, name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.manager.doCommand(new CommandZoomPlus(this.perspective));
	}

}
