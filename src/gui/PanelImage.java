package gui;

import model.ImageCustom;
import model.Perspective;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanelImage extends JPanel {
	
    private JLabel lab;
    private ImageCustom model;

    public PanelImage(ImageCustom model){
        this.model=model;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(model.getImage() == null) {
        	return;
        }
        
        BufferedImage image = model.getImage();
        Perspective perspective = model.getCurrentPerspective();
        
        int width = (int)(image.getWidth() * perspective.getZoomLevel());
        int height = (int)(image.getHeight() * perspective.getZoomLevel());
        
        int x = perspective.getTranslation().x;
        int y = perspective.getTranslation().y;
        
        g.drawImage(image,x,y,width,height,null);
    }
}
