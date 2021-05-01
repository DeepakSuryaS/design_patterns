Think of it as subscribers to a blog. Subscribers are observers and the blog notifies them of any changes.


We'll have a Subject superclass, that defines three methods:
1. Allow a new observer to subscribe
2. Allow a current observer to unsubscribe
3. Notify all observers about a new blog post

This superclass will also have an attribute to keep track of all the observers, and we'll make an Observer Interface with methods that an observer can be notified to update itself. 
Next, the blog Class will be a subclass of the Subject superclass, and the Subscriber Class will implement the observer interface. 

These design elements are essential to forming a Subject and Observer relationship. 

Another example would be, social media such as FB, Twitter where all followers get notified if someone changes status or posts something.
Other examples would be,
1. an auction and a bidder
2. news broadcast and viewers etc

In each of these, relationships are generally one subject to many observers.



### CORE BEHAVIOUR:
In a sequence diagram that applies an observer pattern, there are two major rules, the Subject and the Observer.
Which in our example are played by a blog and a Subscriber. In order to form the Subject and Observer relationship, a Subscriber must subscribe to the blog. Next, the blog needs to be able to notify its subscribers that a change has happened. It's the job of the notify function to keep all of the subscribers consistent. This method is only called when the blog has a change, ready for its subscribers to know about. After the blog has a change, it's time for the blog to notify its subscribers through an update call, and the subscribers to get the state of the blog through a get state call. It's up to the blog to make sure its subscribers get the latest information. If the subscriber does not end up enjoying the content of the blog, they would need a way to unsubscribe. That is the last call in the sequence diagram. It originates from the subscriber, and lets the blog know the subscriber should be removed from its list of subscribers. This is the core behavior for the Observer Design Pattern, an essential for our subscriber to be able to subscribe to a blog they like. 



### UML class diagram:
the subject superclass has three methods, register observer, unregister observer, and notify. These are all essential for a subject to elate to its observers. Specifically, the blog subclass of subject would inherit these methods to subscribe, unsubscribe and notify its subscribers. The observer interface only has the update method. An observer must always have some way to update itself, without the ability to be told to update an observer wouldn't be informed of changes in the subject. The Subscriber class implements the observer interface, providing the body of an update method so a subscriber can get what changed in the blog. Note that a subject may have zero or more observers registered to it at any given time.



### Program
Subject.class
```
public class Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notify() {
        for (Observer o : observers) {
            o.update();
        }
    }
}
```

Blog.java - subclass of Subject
Will inherit the register observer, unregister observer and notify methods and have the other responsibilities of managing a blog and posting messages.

```
public class Blog extends Subject {
    private String state;
    
    public String getState() {
        return state;
    }

    // blog responsibilities
    ...
}
```

Observer.java - interface
```
public class Observer {
    public void update();
}
```


Subscriber.java
```
public class Subscriber implements Observer {
    public void update() {
        // get the blog change(s)
        ...
    }
}
```



The observer interface makes sure all observer objects behave the same way. Observer classes only need to implement a single method, update. The update method is called by the subject. The subject makes sure when a change happens, all its observers are notified to update themselves. 

The observer design pattern can save you a lot of time when you're implementing your system. *If you know that you have many objects that rely on the state of one, the value of the observer pattern becomes more pronounced.* Instead of managing all the observer objects individually, you can have your subject manage them and make sure the observers are updating themselves as needed. There are many different ways and situations you can apply the observer design pattern. As a behavioral pattern, it makes it easy to distribute and handle notifications of changes across systems, in a manageable and controlled way. 