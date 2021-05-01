Subject.java
```
public class Subject {
    public void registerObserver(Observer observer);
    public void unregisterObserver(Observer observer);
    public void notifyObservers();
}
```


Channel.java
```
public class Channel implements Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String channelName;
    private String status;

    public Channel(String channelName, String status) {
        this.channelName = channelName;
        this.status = status;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }
}
```


Observer.java
```
public class Observer {
    public void update(String status);
}
```


Follower.java
```
public class Follower implements Observer {
    private String followerName;

    publiv Follower(String followerName) {
        this.followerName = followerName;
    }

    public String getFollowerName() {
        return followerName;
    }

    public void setFollowerName(String followerName) {
        this.followerName = followerName;
    }

    public void update(String status) {
        // send message to followers that channel is live
        ...
    }

    public void play() {
        // play videos on channel
    }
}
```
