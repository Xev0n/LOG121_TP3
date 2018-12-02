package gui;

import controller.PerspectiveImageController;
import model.Perspective;

import javax.swing.*;
import java.awt.*;

public class PanelZoom extends JPanel {
	private JButton btnZoomUp;
	private JButton btnZoomDown;
	private Perspective model;


	public PanelZoom(Perspective model){
		btnZoomUp=new JButton("Zoom +");
		btnZoomDown=new JButton("Zoom -");

		btnZoomUp.addActionListener(new PerspectiveImageController());
		btnZoomDown.addActionListener(new PerspectiveImageController());
		this.setLayout(new GridLayout(1,3));
		this.add(btnZoomUp);
		this.add(btnZoomDown);




	}
}
