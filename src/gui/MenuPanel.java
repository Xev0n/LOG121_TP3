package gui;

import model.ImageCustom;
import model.Perspective;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import commandes.CommandChangePerspective;
import commandes.CommandManager;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuPanel extends JMenuBar {

		private static final long serialVersionUID = 1L;
		private static final String MENU_FICHIER_TITRE = "Fichier";
		private static final String MENU_FICHIER_CHARGER = "Charger";
		private static final String MENU_FICHIER_QUITTER = "Quitter";
		private static final String MENU_AIDE_TITRE = "Aide";
		private static final String MENU_AIDE_PROPOS = "A propos de...";
		private static final String MENU_PERSPECTIVES = "Perspective";
		private ImageCustom model;

		public MenuPanel(ImageCustom model) {
			this.model=model;
			ajouterMenuFichier();
			ajouterMenuPerspectives();
			ajouterMenuAide();

		}

		/**
		 * Cr�er le menu de Fichier
		 */
		private void ajouterMenuFichier() {
			JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
			JMenuItem menuCharger = new JMenuItem(MENU_FICHIER_CHARGER);
			JMenuItem menuQuitter = new JMenuItem(MENU_FICHIER_QUITTER);

			menuCharger.addActionListener((ActionEvent e) -> {
				JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				fileChooser.setDialogTitle("Selectionnez une image");
				fileChooser.setAcceptAllFileFilterUsed(false);
				// Cr�er un filtre
				FileNameExtensionFilter filtre = new FileNameExtensionFilter(".jpg", "jpg");
				fileChooser.addChoosableFileFilter(filtre);

				int returnValue = fileChooser.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {

					File selectedFile = fileChooser.getSelectedFile();
					BufferedImage bfImg;
					try {
						bfImg = ImageIO.read(selectedFile);
						model.setImage(bfImg);
						System.out.println("Image choisie : "+selectedFile.getAbsolutePath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});

			menuQuitter.addActionListener((ActionEvent e) -> {
				System.exit(0);
			});

			menuFichier.add(menuCharger);
			menuFichier.add(menuQuitter);

			add(menuFichier);

		}

		/**
		 * Cr�er le menu Aide
		 */
		private void ajouterMenuAide() {
			JMenu menuAide = new JMenu(MENU_AIDE_TITRE);
			JMenuItem menuPropos = new JMenuItem(MENU_AIDE_PROPOS);
			menuAide.add(menuPropos);

			menuPropos.addActionListener((ActionEvent e) -> {
				JOptionPane.showMessageDialog(null,
						"<html><p>Application simulant une chaine de production d'avions.</p>" + "<br>"
								+ "<p>&copy; &nbsp; 2017 &nbsp; Ghizlane El Boussaidi</p>"
								+ "<p>&copy; &nbsp; 2017 &nbsp; Dany Boisvert</p>"
								+ "<p>&copy; &nbsp; 2017 &nbsp; Vincent Mattard</p>" + "<br>"
								+ "<p>&Eacute;cole de technologie sup&eacute;rieure</p></html>");
			});
			add(menuAide);
		}

	/**
	 * Cr�er le menu Aide
	 */
	private void ajouterMenuPerspectives() {
		JMenu menuAide = new JMenu(MENU_PERSPECTIVES);
		for(int i=0; i < model.getNbPerspectives(); i++) {
			JMenuItem menuItem = new JMenuItem("Perspective " + (i+1));
			menuAide.add(menuItem);
			menuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String strIndex = menuItem.getText().split(" ")[1];
					int index = Integer.parseInt(strIndex) - 1;
					CommandManager.getInstance().doCommand(new CommandChangePerspective(model, index));
				}
			});
		}

		add(menuAide);
	}
}
