package actions;

import java.awt.Point;
import java.awt.event.ActionEvent;

import commandes.CommandTranslate;
import model.ImageCustom;
/**
 * Classe permettant de faire une translation de d'une image
 *
 */
public class ActionTranslate extends AbstractActionOnImage {

	private Point translation;
	
	public ActionTranslate(ImageCustom imgCustom, String name, Point translation) {
		super(imgCustom, name);
		this.translation = translation;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.manager.doCommand(new CommandTranslate(imgCustom, translation));
	}
}
