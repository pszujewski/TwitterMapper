package observer_pattern;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

public abstract class TwitterSourceSubject {
    private List<TwitterSourceObserver> observers = new ArrayList<>();

    public boolean addObserver(TwitterSourceObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            return true;
        }
        return false;
    }

    public void notifyObservers(Status s) {
        for (TwitterSourceObserver o : observers) {
            o.update(this, s);
        }
    }

    public boolean removeObserver(TwitterSourceObserver o) {
        if (observers.contains(o)) {
            observers.remove(o);
            return true;
        }
        return false;
    }

    public List<TwitterSourceObserver> getObservers() {
        return observers;
    }
}
