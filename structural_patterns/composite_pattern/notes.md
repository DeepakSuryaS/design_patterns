Consider buildings and rooms. Although they're slightly different, we essentially treat them as generic housing structures. You can enter or exit and store furnishings.
So despite being unique types, they can be uniformly dealt with.

The composite pattern is similar to this, it achieves two goals:
1. Create nested structures of objects
2. Deal with the classes for these objects uniformly

The basic structure is that a component interface serves as as supertype for a set of classes. So that they can all be dealt with uniformly.
This is done by enforcing _polymorphism_. All implementing classes conform to the same interface.

_Note: Abstract super class can also be used in place of an interface as both are allowed for polymorphism._


The composite class is used to aggregate any class that implements the component interface. It will allow us to traverse through and manipulate the component classes it contains.
A leaf class represents a non-composite type. It's not composed of any other components.
We want to deal with non-composite and composite objects uniformly.

Now, the _composite class and the leaf class_ implement the _component interface_. Thus we unify them with a single type. So now, the _composite and leaf classes_ are now considered subtypes of _component_.

Depending on the problem, we can have other _composite and leaf classes_. But only one overall _component interface_, or _abstract super class_.

A composite object can contain other composite objects, since the composite class is a subtype of component. _This is known as recursive composition_, which is another name for this design pattern. 

Visualizing how this design pattern looks can be a little difficult because of the apparent cyclical nature of the composite class. _The easiest way is to think of it like a tree._
1. At the root level we have our main composite object, which is made up of other component objects.
2. At each level, we can add more components below each composite object, like another composite or a leaf.
3. We cannot add anything to the leaf object. This means that a composite object has the potential to grow the tree, while a leaf object effectively ends the tree where it is.


### This design pattern is used to address two issues:
1. How do we use individual types of objects to build a tree-like structure?
2. And how can we treat the individual types of objects uniformly without checking their types?

These two issues are addressed by the design pattern as follows:
1. Each individual class is a subtype of an interface or a superclass, and will be able to conform to the shared behaviours. This means that the leaf and composite classes share behaviour through the component class.
2. The composite class is capable of aggregating component classes, which will create a tree-like structure. This structure allows composites to contain other composites.
3. The leaf and composite both inherit from the component class. This is an important aspect of the structure because it allows composites to contain other composites as well as leafs.



A good example using buildings and rooms would be,
1. A component interface in this case, can be used to describe a building, a floor, or a room despite each being unique types of objects.
2. The housing class is the composite class. A housing is a type of structure, which could also contain other structures, meaning that a housing object could contain other housing objects. For example, a building could be represented by a housing object and the building could contain floors. Each floor could be represented by another housing object.
3. A room is considered a leaf class since a room cannot contain another room. It is contained within a housing like a floor of a building.


Example structure:
#### Component interface
* enter(): void
* exit(): void
* location(): void
* getName(): String

#### Housing
* address: String
* structures: Array
* enter(): void
* exit(): void
* location(): void
* getName(): String

#### Room
* name: String
* enter(): void
* exit(): void
* location(): void
* getName(): String



### Procedure
1. Design the interface that defines the overall type. We start off by defining the interface that the composite and
leaf classes will implement. This supports polymorphism for your component and leaf class.
2. Implement the composite class. You implement the interface in the composite class. This will give the housing class it's own behavior when client code uses it. Since our housing object can be composed of other structures, you'll need to represent this containment with a suitable collection. You will also need a method for adding more components to your composite object. Here, we have used a private array list and changed it only through the public add structure method.
3. Implement the leaf class. Since the leaf class doesn't contain any components, we don't need to add a collection of components to it or any methods to manage a component collection. We simply need to implement the methods of the I structure interface.






### Program sample
Step 1: Design the interface that defines the overall type
```
public interface IStructure {
    public void enter();
    public void exit();
    public void location();
    public String getName();
}
```

Step 2: Implement the composite class
```
public class Housing implements IStructure {
    private ArrayList<IStructure> structures;
    private String address;

    public Housing(String address) {
        this.structures = new ArrayList<IStructure>();
        this.address = address;
    }

    public String getName() {
        return this.address;
    }

    public int addStructure(IStructure component) {
        this.structures.add(component);
        return this.structures.size() - 1;
    }

    public IStructure getStructure(int componentNumber) {
        return this.structures.get(componentNumber);
    }

    public void location() {
        System.out.println("You are currently in " + this.getName() + " It has ");
        for (IStructure struct: this.structures) {
            System.out.println(struct.getName());
        }
    }

    <!-- print out when you enter and exit the building -->
    public void enter() { ... }
    public void exit() { ... }
}
```

Step 3: Implement the leaf class
```
public abstract class Room implements IStructure {
    public String name;

    public void enter() {
        System.out.println("You've entered the " + this.name);
    }

    public void exit() {
        System.out.println("You've left the " + this.name);
    }

    public void location() {
        System.out.println("You're currently in the " + this.name);
    }

    public String getName() {
        return this.name;
    }
}
```

Step 5: Usage example
```
public class Program {
    public static void main(String args[]) {
        Housing building = new Housing("123 street");
        Housing floor1 = new Housing("123 street - First Floor");
        int firstFloor = building.addStructure(floor1);

        Room washroom1m = new Romm("1F Men's Washroom");
        Room washroom1w = new Room("1F Women's Washroom");
        Room common = new Room("1F common area");

        int firstMens = floor1.addStructure(washroom1m);
        int firstWomens = floor1.addStructure(washroom1w);
        int firstCommon = floor1.addStructure(common);

        building.enter(); // Enter the building
        Housing currentFloor = building.getStructure(firstFloor);
        currentFloor.enter(); // Walk into the first floor
        Room currentRoom = currentFloor.getStructure(firstMens);
        currentRoom.enter(); // Walk into men's room
        currentRoom = currentFloor.getStructure(common);
        currentRoom.enter(); // Walk into the common area
    }
}
```

This is obviously very simplistic, but it gives you an idea how powerful this design pattern can be. Composite objects can be built quickly and easily. Each component can be expected to have the same set of behaviors without needing to do any type checking.

To summarize,
* the composite design pattern is used to solve the issues of how to build a tree-like structure of objects, and how to treat the individual types of those objects uniformly.
* This is achieved by enforcing polymorphism across each class through implementing an interface or inheriting from a superclass.
* And using a technique called recursive composition, which allows objects to be composed of other objects that are of a common type. 
* You can think of this design pattern as applying the decomposition and generalization object-oriented design principles together to break a whole into parts, but having the whole and parts both conform to a common type.
* The composite design pattern lets you build complex structures by constructing them using composite objects and leaf objects which belong to a unified component type.
* This makes it easier to understand and manipulate the structure, and will lead to more readable, reusable, and meaningful code.