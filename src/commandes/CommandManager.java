package commandes;

import java.util.LinkedList;
import java.util.Stack;

import model.Perspective;

public class CommandManager {
	
	private Stack<ICommandOnImage> actionsDone;
	private Stack<ICommandOnImage> actionsUndone;
	
	private LinkedList<Perspective> perspectives;
	private static CommandManager manager;
	
	private CommandManager() {
		actionsDone = new Stack<>();
		actionsUndone = new Stack<>();
	}
	
	public void undo(){
		if(actionsDone.isEmpty()) {
			return;
		}
		ICommandOnImage commandOnImage = actionsDone.pop();
		actionsUndone.push(commandOnImage);
		commandOnImage.undo();
	}
	
	public void redo() {
		if(actionsUndone.isEmpty()) {
			return;
		}
		ICommandOnImage commandOnImage = actionsUndone.pop();
		actionsDone.push(commandOnImage);
		commandOnImage.execute();
	}
	
	public void reset(){
		actionsDone.clear();
	}
	
	public static CommandManager getInstance(){
		if(manager == null)
			manager = new CommandManager();
		return manager;			
	}

	public void doCommand(ICommandOnImage command) {
    	command.execute();
    	actionsDone.push(command);
	}
}
