package commandes;

import java.util.LinkedList;
import java.util.Stack;

import model.Perspective;

public class CommandManager {
	private Stack<ICommandOnImage> actions;
	private LinkedList<Perspective> perspectives;
	private static CommandManager manager;
	
	private CommandManager() {
		actions = new Stack();
	}
	
	public void undo(){
		
	}
	
	public void reset(){
		
	}
	
	public static CommandManager getInstance(){
		if(manager == null)
			manager = new CommandManager();
		return manager;			
	}

	public void doCommand(ICommandOnImage command) {
    	if (command.execute()) {
    		actions.add(command);
    	} 		
	}
}
