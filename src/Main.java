import gui.PerspectiveImageView;
import model.ImageCustom;
import commandes.CommandLoad;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        BufferedImage bufferedImage;
		try {
			ImageCustom imgCustom = new ImageCustom();
			CommandLoad commande = new CommandLoad(imgCustom);
			commande.execute();
	        PerspectiveImageView piw = new PerspectiveImageView(imgCustom);
	        System.out.println("Image correctly loaded.");
		} catch (Exception e) {
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
}
