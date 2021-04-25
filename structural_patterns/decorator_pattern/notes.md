In software, like devising a new beverage, it's beneficial to have flexible combinations of overall behaviours. But we encounter an issue trying to do this dynamically at runtime, because behaviour of an object is defined by its class, but the notion of a class and relationships like inheritance are static i.e., happen at runtime. This means that we cannot make changes to classes while our program is running. We need to create a new class in order to achieve new combination of behaviours. As a result, having lots of new combinations would lead to lots of classes and we don't want that.

Given that an object has a certain behaviour, we can still dynamically attach additional behaviours or responsibilities to it using the decorator pattern. It uses aggregation to combine behaviours at runtime.
Aggregation is used to represent a "has a" or a "weak containment" relationship between two objects.

We can use the "has a" relationship to build a stack of objects where each level of the stack contains an object that knows about its own behaviour and augments the one underneath it in the stack.

The aggregation relationship is always one-to-one in the decorator design pattern in order to build up the stack so that one object is on top of another. To achieve an overall combination of behaviour for the stacked objects, you would call upon the top element.

The actual structure of this design pattern makes use of both interfaces and inheritance so that the classes conform to a common type, whose instances can be stacked up in a compatible way to build up a coherant combination of behaviour overall.


1. The component interface is used to define the common type for all the classes. The client will expect the same interface across all the component classes.
2. A concrete component class implements the component interface and can be instantiated. An instance of this class can be used as a base object in the stack.


Decorator is an abstract class, just like the concrete component class, it implements the component interface.
The main differences are that,
1. decorator aggregates other types of components, which will allow us to stack components on top of each other.
2. and serves as the abstract superclass of concrete decorator classes that will each provide an increment of behaviour. 


We build the stack of components starting with an instance of the concrete component class and continuing with instances of subclasses of the decorator abstract class. 

In terms of coffee analogy, concrete component would be a black coffee, decorators of our coffee would be milk, sugar, hot chocolate etc.


### What are the reasons for using the decorator design pattern?
1. It allows objects to dynamically add behaviours to others.
2. To reduce the number of classes needed to offer a combination of behaviours.


But, these analogies don't translate well to how you would actually make use of this design pattern for software. 

So, let's look at an example that is more realistic to what you would see in a software system. A web page is an example of where we would use this design pattern. A basic web page is simply a markup using HTML with stylesheets and possibly some Javascript.
However, the behavior of a web page can be more complex. What if you want to make sure that people accessing your page are authorized?
Or what if you want to split a large number of search results into separate pages? You don't want to write completely different web page types for every possible combination of web page permission, pagination, or caching behaviors. Instead, you can use a decorator design pattern to create one class for each type of behavior, and build the specific combination of web page that you want at runtime. 


Your component interface is a web page. This will define all subclasses in the pattern as a type of web page which have their own implementation of how to display themselves. The concrete component class is your basic web page. It consists of HTML, a stylesheet,
and scripts, which we will represent as strings for the sake of simplicity. This basic web page should know how to display all of its web page elements. Now, you need decorators to add more functionality to your basic web page using aggregation instead of subclassing the basic web page itself. You will need to use subtypes of the abstract web page decorator class to augment our basic web page.
As we explored earlier, the web page decorator will be a subtype of web page. Therefore, a subtype of the decorator is also a subtype of the web page interface. You can define any number of additional behaviors you want to augment your basic web page with. 



In this example, we will enhance the basic web page by adding authorization to ensure the user can access the page, and authentication to make sure the user is who they claim to be. Can you see how this reduces the number of classes we would need to create? If you used inheritance of the basic web page, you would need to create a class for every combination of these behaviors. That means we would need a separate class for the combined authorization and authentication functions. The decorator design pattern addresses this problem by allowing concrete decorators to aggregate any type of component. 





To summarize, the key concepts for this design pattern are that,
1. we can add in effect any number of behaviors dynamically to an object at runtime by using aggregation as a substitute for pure inheritance.
2. Polymorphism is achieved by implementing a single interface.
3. Aggregation lets us create a stack of objects.
4. Each decorator object in the stack is aggregated in a one-to-one relationship with the object below it in the stack.
5. And, by combining aggregation and polymorphism, we can recursively invoke the same behavior down the stack and have the behavior execute upwards from the concrete component object. 

Not only does the decorator design pattern let you dynamically modify objects but it also reduces the variety of classes you would need to write. A larger code base not only takes more time to complete but it is also difficult to maintain, and can reduce the flexibility of your system. You want to have a robust system but without the headache of having an enormous amount of code to write and look after.
Using design patterns like the decorator pattern will help you create complex software without the complex overhead. 



I haven't covered programs for the section. Please refer to the video linked below.


TLDR - https://www.coursera.org/learn/design-patterns/lecture/Sh7W4/2-1-9-decorator-pattern