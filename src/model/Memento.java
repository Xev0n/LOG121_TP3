package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Memento implements Serializable{
    private transient BufferedImage image;
    private Perspective[] perspectives;
    private int indexCurrentPerspective;
    private static final long serialVersionUID = -1496543845304703683L;

    public Memento(ImageCustom ic){
        this.image=ic.getImage();
        this.indexCurrentPerspective=ic.getCurrentPerspectiveIndex();
        this.perspectives=ic.getPerspectives();

    }

    //redefine the write object to save the image
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(image, "png", out);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        image=ImageIO.read(in);

    }

    public BufferedImage getImage() {
        return image;
    }

    public Perspective[] getPerspectives() {
        return perspectives;
    }

    public int getIndexCurrentPerspective() {
        return indexCurrentPerspective;
    }
}
