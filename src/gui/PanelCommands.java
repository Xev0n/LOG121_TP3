package gui;

import model.ImageCustom;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCommands extends JPanel {
	
    private PanelTranslation pt;
    private PanelZoom pz;
    private ImageCustom model;
    private JComboBox jc;

    public PanelCommands(ImageCustom model) {
    	
        this.model = model;
        
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
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(imageIcon);

        this.add(pt);
        this.add(pz);
        this.add(imgLabel);
    }

}
