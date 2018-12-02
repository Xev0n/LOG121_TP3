package gui;

import model.Perspective;

import javax.swing.*;
import java.awt.*;

public class PanelImage extends JPanel {
    private JLabel lab;
    private Perspective model;


    public PanelImage(Perspective model){
        this.model=model;


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon imageIcon = new ImageIcon(model.getImage()); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(500, 400,  java.awt.Image.SCALE_SMOOTH);
        g.drawImage(newimg,0,0,500,400,null);
    }




}
