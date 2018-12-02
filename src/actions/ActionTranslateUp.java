package actions;

import java.awt.event.ActionEvent;

import commandes.CommandTranslateUp;
import model.Perspective;

public class ActionTranslateUp extends AbstractActionOnImage{


	public ActionTranslateUp(Perspective perspective, String name) {
		super(perspective, name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.manager.doCommand(new CommandTranslateUp(this.perspective));
	}

}
