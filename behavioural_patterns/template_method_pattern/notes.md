Have you seen the directions on making soup or mixing a drink from powdered ingredients? They would both have similarly described steps to get a container. Empty the ingredients into the container, add water, stir and prepare. The steps are ordered the same way, with some identical steps and some different in implementation. 


You can model this situation with a *pastaDish class with a method that makes the recipe for each subclass*, spaghettiWithMeatballs or penneAlfredo. The method knows the general set of steps to make either dish from boiling water to adding the garnish. *Steps that are special to a dish, like the sauce to add, are implemented in its subclass*. These are all elements of the template method pattern.


The template method defines an algorithm's steps generally, deferring the implementation of some steps to subclasses. It is a behavioral design pattern and is concerned with the assignment of responsibilities. 


### Example:
------------
Template method for self-driving vehicle class:
Name - driveToDestination()

Both the self-driving car and motorcycle would require such a function for reaching their destination. They would need to go through all the steps together. This steps would involve accelerating, steering, breaking and checking if there are other destination. Calls to all of these methods will be laid out inside the template method. It would be called the same way for both subclasses. Though some of the methods being called would differ. For example, how you stir a car is different from how you stir a motorcycle. The template method is best used when you can generalize between two classes into a new super class. Think of it like another technique to use when you notice you have two separate classes with very similar functionality in order of operations. After you use generalization, you can more effectively reuse objects using inheritance, you can share the functionality between classes and allow for clearer and more self-explanatory code.

[Code for this example is given after the pasta dish code.]
 
-------------


We have the pastaDish superclass with a template method, makeRecipe which calls other methods for the steps of the recipe. Some steps are common across specific dishes like boiling water, so boilWater is a method of PastaDish. However, some steps are special to dish like adding the sauce. So addSauce is an abstract method of PastaDish, it will be up to a subclass of pasta dish to provide the addSauce method body to add the right sauce. SpaghettiMeatballs and PenneAlfredo are subclasses of the PastaDish class. They must provide their own versions of addPasta, addSauce, addProtein, and addGarnish. 



### Program
PastaDish.java - superclass
```
public abstract class PastaDish {
    public final void makeRecipe() {
        boilWater();
        addPasta();
        cookPasta();
        drainAndPlate();
        addSauce();
        addProtein();
        addGarnish();
    }

    protected abstract void addPasta();
    protected abstract void addSauce();
    protected abstract void addProtein();
    protected abstract void addGarnish();

    private void boilWater() {
        System.out.println("Boiling water.");
    }
    ...
}
```

PastaDish needs to be an abstract class. You can't create a generic PastaDish, you wouldn't know what pasta, protein, sauce, and garnish to add. So those methods are abstract. The makeRecipe method is our template method. You will notice that this method is marked as final. In Java, the final keyword means that the method declared cannot be overridden by subclasses. This means that neither specific dish subclass can have its own version of makeRecipe. This ensures consistency in the steps of making the dishes and reduces redundant code. 

SpaghettiMeatBalls.java - subclass
```
public class SpaghettiMeatBalls extends PastaDish {
    protected void addPasta() {
        System.out.println("Add spaghetti");
    }

    protected void addSauce() {
        System.out.println("Add tomato sauce");
    }

    protected void addProtein() {
        System.out.println("Add meatballs");
    }

    protected void addGarnish() {
        System.out.println("Add Parmesan cheese");
    }
}
```

PenneAlfredo.java - subclass
```
public class PenneAlfredo extends PastaDish {
    protected void addPasta() {
        System.out.println("Add penne");
    }

    protected void addSauce() {
        System.out.println("Add Alfredo sauce");
    }

    protected void addProtein() {
        System.out.println("Add chicken");
    }

    protected void addGarnish() {
        System.out.println("Add parsley");
    }
}
```



### Program for Self-Driving Vehicle

```
public abstract class SelfDrivingVehicle {
    public final void driveToDestination() {
        accelerate();
        steer();
        brake();
        reachDestination();
    }

    abstract void accelerate();
    abstract void steer();
    abstract void brake();

    private void reachDestination() { // this is private because the subclasses don't need to access it.
        System.out.println("Made it to the destination!");
    }
}
```

SelfDrivingCar.java - subclass
```
public class SelfDrivingCar extends SelfDrivingVehicle {
    protected void accelerate() {
        System.out.println("Press the accelerating pedal");
    }

    protected void steer() {
        System.out.println("Turning steering wheel");
    }

    protected void brake() {
        System.out.println("Press the brake pedal");
    }
}
```

SelfDrivingMotorcycle.java - subclass
```
public class SelfDrivingMotorcycle extends SelfDrivingVehicle {
    protected void accelerate() {
        System.out.println("Twist the Accelerate/throttle");
    }

    protected void steer() {
        System.out.println("Turning handlebar(s)");
    }

    protected void brake() {
        System.out.println("Pull brake levers");
    }
}
```



The template method can be helpful if you have two classes with similar functionality. when you notice two classes with a very similar order of operations, you can choose to use a template method. The template method pattern is a practical application of generalization
and inheritance. When writing software, you might notice two separate classes that share similarities like each having a method with a very similar algorithm. Rather than making changes to these algorithms in two places, you can consolidate the algorithms to one place
within a template method of a superclass for the two classes. You generalize from two separate methods into one template method within a superclass which will be inherited by the two classes. The differences in the algorithms would be done through calls to abstract methods
whose implementations are provided by the subclasses. 