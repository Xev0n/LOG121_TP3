package gui;

import model.ImageCustom;
import observer.IObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanelCommands extends JPanel implements IObserver {
	
    private PanelTranslation pt;
    private PanelZoom pz;
    private JComboBox jc;
    private JLabel imgLabel;

    public PanelCommands(ImageCustom model) {
    	
        pt = new PanelTranslation(model);
        pz = new PanelZoom(model);
        GridLayout layout = new GridLayout(1,3);
        layout.setHgap(20);
        this.setLayout(layout);

        //from stackoverflow
        BufferedImage snapshot = model.getImage();
        ImageIcon imageIcon = new ImageIcon(model.getImage()); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        imgLabel = new JLabel();
        imgLabel.setIcon(imageIcon);

        this.add(pt);
        this.add(pz);
        this.add(imgLabel);
    }

    @Override
    public void update() {
        System.out.println("Update");

        repaint();
    }



}
