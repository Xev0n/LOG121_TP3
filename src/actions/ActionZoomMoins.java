package actions;

import java.awt.event.ActionEvent;

import commandes.CommandTranslateDown;
import commandes.CommandTranslateUp;
import commandes.CommandZoomMoins;
import commandes.CommandZoomPlus;
import model.Perspective;

public class ActionZoomMoins extends AbstractActionOnImage{


	public ActionZoomMoins(Perspective perspective, String name) {
		super(perspective, name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.manager.doCommand(new CommandZoomMoins(this.perspective));
	}

}
