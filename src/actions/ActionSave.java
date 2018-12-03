package actions;

import java.awt.event.ActionEvent;

import commandes.CommandSave;
import model.ImageCustom;

public class ActionSave extends AbstractActionOnImage{
	
	private static final long serialVersionUID = 1L;

	public ActionSave(ImageCustom imgCustom, String name) {
		super(imgCustom, name);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		CommandSave commande = new CommandSave(imgCustom);
		commande.execute();
	}
}
