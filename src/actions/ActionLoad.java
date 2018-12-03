package actions;

import java.awt.event.ActionEvent;

import commandes.CommandLoad;
import model.ImageCustom;

public class ActionLoad extends AbstractActionOnImage {
	
	public ActionLoad(ImageCustom imgCustom, String name) {
		super(imgCustom, name);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		CommandLoad commande = new CommandLoad(imgCustom);
		commande.execute();
	}

}
