package actions;

import java.awt.event.ActionEvent;

import commandes.CommandTranslateDown;
import commandes.CommandTranslateUp;
import model.Perspective;

public class ActionTranslateDown extends AbstractActionOnImage{


	public ActionTranslateDown(Perspective perspective, String name) {
		super(perspective, name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.manager.doCommand(new CommandTranslateDown(this.perspective));
	}

}
