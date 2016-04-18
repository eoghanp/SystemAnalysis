package Vehicle;

import route.Route;

public interface Subject {

	public void registerObserver(Route observer);
	public void removeObserver(Route observer);
	public void notifyObservers();
}
