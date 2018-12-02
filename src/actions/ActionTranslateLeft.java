package actions;

import java.awt.event.ActionEvent;

import commandes.CommandTranslateLeft;
import commandes.CommandTranslateUp;
import model.Perspective;

public class ActionTranslateLeft extends AbstractActionOnImage{


	public ActionTranslateLeft(Perspective perspective, String name) {
		super(perspective, name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.manager.doCommand(new CommandTranslateLeft(this.perspective));
	}

}
