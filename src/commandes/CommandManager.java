package commandes;

import java.util.LinkedList;
import java.util.Stack;

import model.Perspective;

public class CommandManager {
	
	private Stack<ICommandOnImage> actions;
	private LinkedList<Perspective> perspectives;
	private static CommandManager manager;
	
	private CommandManager() {
		actions = new Stack<>();
	}
	
	public void undo(){
		// depile et call le undo de l'élement
	}
	
	public void reset(){
		actions.clear();
	}
	
	public static CommandManager getInstance(){
		if(manager == null)
			manager = new CommandManager();
		return manager;			
	}

	public void doCommand(ICommandOnImage command) {
    	command.execute();
    	actions.push(command);
	}
}
