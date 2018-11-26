package gui;

import model.Perspective;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PerspectiveImageView extends JFrame implements Observer {
	
	private PanelImage panelImg;
	private PanelCommands panelCommands;
	private Perspective model;

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Devoir 2 - Log121";
	private static final Dimension DIMENSION = new Dimension(500, 500);

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public PerspectiveImageView (Perspective model){
		this.model=model;
		initFrame();
	}

	private void initFrame(){
		panelImg=new PanelImage();
		PanelCommands pc = new PanelCommands();
		PanelZoom pz=new PanelZoom();
		PanelTranslation pt= new PanelTranslation();
		this.add(panelImg);
		this.add(pc);
		this.add(pz);
		this.add(pt);


		// Faire en sorte que le X de la fen�tre ferme la fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		// Rendre la fen�tre visible
		setVisible(true);
		// Mettre la fen�tre au centre de l'�cran
		setLocationRelativeTo(null);
		// Emp�cher la redimension de la fen�tre
		setResizable(false);


	}
}
