package gui;

import controller.PerspectiveImageController;
import model.ImageCustom;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import actions.ActionZoomMoins;
import actions.ActionZoomPlus;


public class PanelZoom extends JPanel {
	
	private JButton btnZoomUp;
	private JButton btnZoomDown;
	private ImageCustom model;

	public PanelZoom(ImageCustom model){
		btnZoomUp = new JButton(new ActionZoomPlus(model,"Zoom +"));
		btnZoomDown = new JButton(new ActionZoomMoins(model, "Zoom -"));
		
		this.setLayout(new GridLayout(1,3));
		this.add(btnZoomUp);
		this.add(btnZoomDown);
	}
}
