package gui;

import commandes.CommandChangePerspective;
import commandes.CommandManager;
import model.ImageCustom;
import model.Memento;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import actions.ActionLoad;
import actions.ActionSave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class MenuPanel extends JMenuBar {

		private static final long serialVersionUID = 1L;
		private static final String MENU_FICHIER_TITRE = "Fichier";
		private static final String MENU_FICHIER_CHARGER = "Charger image";
	    private static final String MENU_FICHIER_CHARGER_P = "Charger image sauvegarde";
		private static final String MENU_FICHIER_SAUVEGARDE = "Sauvegarder";
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
		 * Crï¿½er le menu de Fichier
		 */
		private void ajouterMenuFichier() {
			JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
			JMenuItem menuCharger = new JMenuItem(MENU_FICHIER_CHARGER);
			JMenuItem menuSauve = new JMenuItem(MENU_FICHIER_SAUVEGARDE);
			JMenuItem menuQuitter = new JMenuItem(MENU_FICHIER_QUITTER);
			JMenuItem menuChargerP = new JMenuItem(MENU_FICHIER_CHARGER_P);

			menuCharger.addActionListener((ActionEvent e) -> {
				JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				fileChooser.setDialogTitle("Selectionnez une image");
				fileChooser.setAcceptAllFileFilterUsed(false);
				// Crï¿½er un filtre
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
						model.update();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});

			menuQuitter.addActionListener((ActionEvent e) -> {
				System.exit(0);
			});

			menuChargerP.addActionListener(new ActionLoad(model, "Charger"));
			menuSauve.addActionListener(new ActionSave(model, "Sauvegarder"));

			menuFichier.add(menuCharger);
			menuFichier.add(menuQuitter);
			menuFichier.add(menuSauve);
			menuFichier.add(menuChargerP);

			add(menuFichier);
		}

		/**
		 * Crï¿½er le menu Aide
		 */
		private void ajouterMenuAide() {
			JMenu menuAide = new JMenu(MENU_AIDE_TITRE);
			JMenuItem menuPropos = new JMenuItem(MENU_AIDE_PROPOS);
			menuAide.add(menuPropos);

			menuPropos.addActionListener((ActionEvent e) -> {
				JOptionPane.showMessageDialog(null,
						"<html><p>Application permettand la vue d'une image selon plusieurs perspectives.</p>" + "<br>"
								+ "<p>&copy; &nbsp; 2018 &nbsp; Alec Durocher</p>"
								+ "<p>&copy; &nbsp; 2018 &nbsp; Jérémy Grenier-Turcotte</p>"
								+ "<p>&copy; &nbsp; 2018 &nbsp; Antonin Courtin</p>"
								+ "<p>&copy; &nbsp; 2018 &nbsp; Philippe Nyamba</p>" + "<br>"
								+ "<p>&Eacute;cole de technologie sup&eacute;rieure</p></html>");
			});
			add(menuAide);
		}

	/**
	 * Crï¿½er le menu Aide
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
