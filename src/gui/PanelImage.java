package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import controller.PerspectiveImageController;
import model.ImageCustom;
import model.Perspective;

public class PanelImage extends JPanel {
	
    private ImageCustom model;
    private PerspectiveImageController controller;

    public PanelImage(ImageCustom model){
        this.model = model;
        controller = new PerspectiveImageController(model);
        setFocusable(true);
        addMouseWheelListener(controller);
        addMouseListener(controller);
        addMouseMotionListener(controller);
        addKeyListener(controller);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(model.getImage() == null) {
        	System.out.println("no image");
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
