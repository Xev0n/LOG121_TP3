package commandes;

import java.awt.TrayIcon.MessageType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.JOptionPane;

import model.ImageCustom;
import model.Memento;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CommandSave extends AbstractCommand implements ICommandOnImage {

	public CommandSave(ImageCustom imgCustom) {
		super(imgCustom);
	}

	@Override
	public void execute() {
		try {
			Date date = new Date();
			
			String dateString = date.getYear() + "_" + date.getMonth() + "_" + 
					date.getDay() + "_" + date.getHours() + "_" + date.getMinutes() + 
					"_" +date.getSeconds();
			String directory = System.getProperty("user.dir");
			String fileName = directory + System.getProperty("file.separator") + dateString + ".txt";
			File file = new File(fileName);
			file.createNewFile();
			FileOutputStream f = new FileOutputStream(file);
			ObjectOutputStream o = new ObjectOutputStream(f);

			Memento m= new Memento(imgCustom);
			o.writeObject(m);

			o.close();
			f.close();
			
			JOptionPane.showMessageDialog(null, "Le travail effectué a été sauvegardé avec succès dans le dossier : "+directory+".");
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void undo() {
		throw new NotImplementedException();
	}
}
