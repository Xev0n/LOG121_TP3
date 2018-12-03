package actions;

import java.awt.event.ActionEvent;

import commandes.CommandZoomMoins;
import model.ImageCustom;

public class ActionZoomMoins extends AbstractActionOnImage{

	public ActionZoomMoins(ImageCustom imageCustom, String name) {
		super(imageCustom, name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.manager.doCommand(new CommandZoomMoins(imgCustom));
	}

}
