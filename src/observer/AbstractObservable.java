package observer;

import java.util.ArrayList;
import java.util.List;

public class AbstractObservable {
	private List<IObserver> observers;
	
	public AbstractObservable() {
		this.observers = new ArrayList<>();
	}
	
	protected void notifyObservers() {
		for(IObserver o: observers)
			o.update();
	}
	
	public void addObserver(IObserver o) {
		this.observers.add(o);
	}
}
