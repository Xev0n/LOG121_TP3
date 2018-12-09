package actions;

import java.awt.event.ActionEvent;

import commandes.CommandZoomPlus;
import model.ImageCustom;

/**
 * Classe permettant de zoomer une image
 *
 */
public class ActionZoomPlus extends AbstractActionOnImage{

	public ActionZoomPlus(ImageCustom imgCustom, String name) {
		super(imgCustom, name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.manager.doCommand(new CommandZoomPlus(imgCustom));
	}

}
