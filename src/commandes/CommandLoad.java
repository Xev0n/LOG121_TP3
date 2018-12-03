package commandes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import model.ImageCustom;
import model.Memento;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CommandLoad extends AbstractCommand implements ICommandOnImage {

	public CommandLoad(ImageCustom imgCustom) {
		super(imgCustom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setDialogTitle("Selectionnez une sauvegarde");
		fileChooser.setAcceptAllFileFilterUsed(false);
		// Cr�er un filtre
		FileNameExtensionFilter filtre = new FileNameExtensionFilter(".txt", "txt");
		fileChooser.addChoosableFileFilter(filtre);

		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {

			File selectedFile = fileChooser.getSelectedFile();

			try {
				FileInputStream f = new FileInputStream(selectedFile);
				ObjectInputStream o = new ObjectInputStream(f);

				Memento m= (Memento) o.readObject();
				imgCustom.setImage(m.getImage());
				imgCustom.setIndexCurrentPerspective(m.getIndexCurrentPerspective());
				imgCustom.setTabPerspectives(m.getPerspectives());
				imgCustom.update();
				CommandManager.getInstance().reset();

				o.close();
				f.close();
			} catch (FileNotFoundException ex) {
				System.out.println("File not found");
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void undo() {
		throw new NotImplementedException();
	}
	
}
