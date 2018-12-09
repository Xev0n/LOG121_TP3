package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Implémentation du patron Memento pour la sauvegarde d'instances d'ImageCustom
 * @author Alec
 *
 */
public class Memento implements Serializable{
    private transient BufferedImage image;
    private Perspective[] perspectives;
    private int indexCurrentPerspective;
    private static final long serialVersionUID = -1496543845304703683L;

    /**
     * Instancie un memento
     * @param ic imagecustom
     */
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

    /**
     * Obtient l'image
     * @return image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Obtient les perspectives
     * @return perspectives
     */
    public Perspective[] getPerspectives() {
        return perspectives;
    }

    /**
     * Obitent l'index courant
     * @return index
     */
    public int getIndexCurrentPerspective() {
        return indexCurrentPerspective;
    }
}
