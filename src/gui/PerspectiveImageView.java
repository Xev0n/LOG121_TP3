package gui;

import model.Perspective;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PerspectiveImageView extends JFrame implements Observer {
	
	private PanelImage panelImg;
	private PanelCommands pc;
	private Perspective model;
	private MenuPanel mp;
	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Devoir 2 - Log121";
	private static final Dimension DIMENSION = new Dimension(500, 500);

	@Override
	public void update(Observable o, Object arg) {

		
	}

	public PerspectiveImageView (Perspective model){
		this.model=model;
		initFrame();
	}

	private void initFrame(){
		panelImg=new PanelImage(model);
		mp=new MenuPanel(model);
		pc = new PanelCommands(model);
		this.setJMenuBar(mp);
		setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		panelImg.setPreferredSize(new Dimension(490,400));
		this.add(panelImg);
		pc.setPreferredSize(new Dimension(490,100));
		this.add(pc);






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
		pack();



	}
}
