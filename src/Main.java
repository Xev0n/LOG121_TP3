import gui.PerspectiveImageView;
import model.ImageCustom;
import commandes.CommandLoad;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
    	// TODO: Exécuter la commande load pour choisir une image custom existance
    	// dans le catch on exécute le code ci-dessous pour charger l'image de castor de base
    	// Fixer le probleme du panel qui a lair de ne plus etre observeur du model apres le load...
    	BufferedImage bufferedImage;
    	// If we catch an exception, it means no save have been made earlier.
		try {
			bufferedImage = ImageIO.read(new java.io.File("src/resources/castor.jpg"));
			ImageCustom imageCustom = new ImageCustom(bufferedImage);
	        PerspectiveImageView piw = new PerspectiveImageView(imageCustom);
	        System.out.println("No previous image found, opening default image.");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
}
