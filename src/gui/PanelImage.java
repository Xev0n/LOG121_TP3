package gui;

import model.ImageCustom;
import model.Perspective;

import javax.swing.*;

import controller.PerspectiveImageController;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

public class PanelImage extends JPanel {
	
    private JLabel lab;
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
