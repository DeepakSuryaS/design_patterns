The Chain of Responsibility is what it sounds like. A chain of objects that are responsible for handling requests. 

Think of it like requesting help on a health problem. So, you try visiting your doctor first with your quest but your case is unusual,
so you're referred to a specialist. But the specialist is on leave and can't take your request and so you referred to another specialist.
And finally, this specialist ends up dealing with your problem. You don't care who along this chain of health professionals actually helps. You only care that your request is met. 

In software design, the Chain of Responsibility is a series of handler objects that are linked together. These handlers have methods that are written to handle specific requests. When a client object sends a request, the first handler in the chain will try to process it. If the handler can process the request, the request ends at this handler. If the handler cannot deal with the request, the handler will send the request to the next handler in the chain who will try to process the request. Again, if the handler cannot process the request, it will send the request onto the next handler. This passing of the request continues until we find the handler that can process the request. If the request goes through the entire chain of handlers and no handler can process it, then the request is not satisfied. 

Say you were fixing a chair and you needed a tool to tighten a particular screw. You're not sure which type of tool to use. You have several types of screwdrivers and wrenches. What would you do? You will probably take each tool and one at a time try it on the screw until one of them works. This is very similar to how the Chain of Responsibility design pattern works. Each object tries to handle the request until one is able to successfully handle it. 

You can also think of this pattern as similar to Exception handling in Java. With Exception handling, you write a series of try-catch blocks in your software to ensure that exceptions are dealt with properly. When an exception occurs, one of the catch blocks is expected to handle it. 

### Where might you use this design pattern in your software?
The Chain of Responsibility can be used for many different purposes. Suppose you are setting up an email service where there are lots of ways to filter through the emails, an email message is considered by a series of filters until one is found that applies. You can create objects that work as the individual filters. Each of these filter objects has a method that I will call Handle request. This method will check if it filters particular rule matches an email messages content. If the rule matches the content, it will deal with the email.
For example, the filter object can put that email into a spam folder and the request is done. If the rule doesn't match the content,
then the filter will call the next filter in the chain to handle the request. Using the Chain of Responsibility design pattern is a very common way to set up this kind of behavior. 

All the objects on the chain are handlers that implement a common method handle request declared in an abstract superclass handler. These handle objects are connected from one to the next in the chain. There are subclasses of handler to handle requests in their own way.

### Can you see an issue with the design?
What if, for example, there's a mistake in the second filter? What if it's rule doesn't match but forgets to pass the request onto the next filter? Then the handling ends prematurely. This is a problem with the Chain of Responsibility. We need an algorithm to make sure that each filter class handles requests in a similar fashion. 

That is, we want to make sure that each filter goes through the following steps.
1. First, check if a rule matches. 
2. If it does match, do something specific. 
3. If it doesn't match, call the next filter in the list.

*To achieve this, you can use the Template Pattern that you learned from an earlier lesson to ensure that each class will handle the request in a similar way following the required steps.*

**Often, design patterns can have their own internal problems and you can use other design patterns to fix those problems. **

It is very common in software design to combine patterns.
The Chain of Responsibility is a very important pattern to learn in software. 


The intent of this design pattern is to avoid coupling the sender to the receiver by giving more than one object the chance to handle the request. Whoever sends the request doesn't have to care who will handle the request. It just sends it to the first thing and hopefully someone will take care of it. This decouples the sender and receiver from each other. All the sender cares is that there is a handler for the request, doesn't care which handler actually services the request. This implementation makes it very easy for the sender. 

For a real life example of this design pattern, let's use a company bureaucracy. You're requesting donations for a worthy cause,
so you ask one of the employees. But they can't authorize such a donation. So your request goes to their manager but the manager doesn't have the budget to donate. So your request goes to a director. The director is not fully convinced of the cause but passes it up the chain to the president. Finally, the president decides to authorize a big donation to your request. Congratulations. As you've seen,
the Chain of Responsibility design pattern is a very useful pattern that can help decouple classes and deal with situations in which
streams of different requests need to be handled. When you come across this issue, try and think of how you can apply the Chain of Responsibility. It won't be easy at first, but after some time in practice, recognizing where and when you need to use this design pattern will come naturally.

