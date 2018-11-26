package controller;

import java.util.LinkedList;
import java.util.Stack;

import model.Perspective;

public class CommandManager {
	private Stack<IActionOnImage> actions;
	private LinkedList<Perspective> perspectives;
	private static CommandManager manager;
	
	public void undo(){
		
	}
	
	public void reset(){
		
	}
	
	public static void getInstance(){
		
	}
}
