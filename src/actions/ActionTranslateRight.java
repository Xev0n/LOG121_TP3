package actions;

import java.awt.event.ActionEvent;

import commandes.CommandTranslateRight;
import model.Perspective;

public class ActionTranslateRight extends AbstractActionOnImage{


	public ActionTranslateRight(Perspective perspective, String name) {
		super(perspective, name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.manager.doCommand(new CommandTranslateRight(this.perspective));
	}

}
