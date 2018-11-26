package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class PerspectiveImageView extends JFrame implements Observer {
	
	private PanelImage panelImg;
	private PanelCommands panelCommands;
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
