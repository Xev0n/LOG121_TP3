package gui;

import model.Perspective;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Point;

import actions.ActionTranslate;

public class PanelTranslation extends JPanel {
	
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnLeft;
	private JButton btnRight;
	private Perspective model;

	public PanelTranslation (Perspective model){
		btnUp = new JButton(new ActionTranslate(model,"Up",new Point(0,-10)));
		btnDown = new JButton(new ActionTranslate(model,"Down", new Point(0,10)));
		btnLeft = new JButton(new ActionTranslate(model,"Left", new Point(-10,0)));
		btnRight = new JButton(new ActionTranslate(model,"Right",new Point(10,0)));

		this.setLayout(new BorderLayout());
		this.add(btnUp, BorderLayout.NORTH);
		this.add(btnDown, BorderLayout.SOUTH);
		this.add(btnLeft, BorderLayout.WEST);
		this.add(btnRight, BorderLayout.EAST);
	}
}
