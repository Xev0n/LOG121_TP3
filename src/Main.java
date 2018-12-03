import gui.PerspectiveImageView;
import model.ImageCustom;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new java.io.File("src/resources/castor.jpg"));
	        ImageCustom imageCustom = new ImageCustom(bufferedImage);
	        PerspectiveImageView piw = new PerspectiveImageView(imageCustom);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
}
