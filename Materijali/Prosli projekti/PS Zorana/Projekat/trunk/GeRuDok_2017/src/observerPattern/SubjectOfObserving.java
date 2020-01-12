package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class SubjectOfObserving 
{
	private static List<Observer> observers = new ArrayList<Observer>();
	private Boolean stateChanged;
	
	public Boolean getStateChanged() {
		return stateChanged;
	}

	
	public void setStateChanged(Boolean stateChanged)
	{
		this.stateChanged = stateChanged;
		if(this.stateChanged)
		{	
			notifyAllObservers();
			this.stateChanged=false;
		}
	}
	
	
	public void attach(Observer observer)
	{
		observers.add(observer);
	}
	
	public void notifyAllObservers()
	{
		for (Observer observer : observers)
		{
			observer.update();
		}
	}
	
	
}
