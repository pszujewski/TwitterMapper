package observer_pattern;

import twitter4j.Status;

public interface TwitterSourceObserver {
    void update(TwitterSourceSubject subject, Status s);
}
