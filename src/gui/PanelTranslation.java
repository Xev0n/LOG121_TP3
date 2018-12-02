package gui;

import controller.PerspectiveImageController;
import model.Perspective;

import javax.swing.*;

import actions.ActionTranslateDown;
import actions.ActionTranslateLeft;
import actions.ActionTranslateRight;
import actions.ActionTranslateUp;

import java.awt.*;

public class PanelTranslation extends JPanel {
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnLeft;
	private JButton btnRight;
	private Perspective model;

	public PanelTranslation (Perspective model){
		btnUp=new JButton(new ActionTranslateUp(model,"Up"));
		btnDown= new JButton(new ActionTranslateDown(model,"Down"));
		btnLeft=new JButton(new ActionTranslateLeft(model,"Left"));
		btnRight=new JButton(new ActionTranslateRight(model,"Right"));

//		btnUp.addActionListener(new PerspectiveImageController());
//		btnDown.addActionListener(new PerspectiveImageController());
//		btnLeft.addActionListener(new PerspectiveImageController());
//		btnRight.addActionListener(new PerspectiveImageController());


		this.setLayout(new BorderLayout());
		this.add(btnUp, BorderLayout.NORTH);
		this.add(btnDown, BorderLayout.SOUTH);
		this.add(btnLeft, BorderLayout.WEST);
		this.add(btnRight, BorderLayout.EAST);
	}
}
