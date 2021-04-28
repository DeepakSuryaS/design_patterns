
The state pattern is primarily used when you need to change the behavior of an object based upon the state that it's in at run-time. 

A vending machine represents state pattern well since it has several states and specific actions based on those states.
Let's say I wanted to purchase a chocolate bar from a vending machine. The chocolate bar costs $1. I walk up to the vending machine, insert my dollar and make my selection. The machine then dispenses the chocolate bar. I take the chocolate bar and go on my merry way.

What if I walked up to the vending machine, inserted my dollar and then decided I didn't want the chocolate bar anymore?
I would press the eject money button and the machine would return my dollar. 

What if the vending machine runs out of chocolate bars? 
The vending machine needs to be keeping track of it's inventory and notifying the customers when there is no more of a particular product left. 

So, the vending machine has three states:
1. idle
2. has one dollar
3. out of stock

Three triggers/events:
1. insert dollar
2. eject money
3. dispense

Two actions:
1. doReturnMoney
2. doReleaseProduct


### Program
```
public class VendingMachine {
    ...
    public VendingMachine(int count) {
        ...
    }
    // handle user events
    public void insertDollar() {
        ...
    }
    public void ejectMoney() {
        ...
    }
    public void dispense() {
        ...
    }
    ...
}
```

Before I approach the vending machine the machine is in an idle state, nothing is happening.

What happens when I insert my dollar?
The state of the vending machine changes.

There are events to respond to and actions to perform that are now relevant to the vending machine. These would be responding to an eject money request by returning my money, and responding to a dispense request by releasing a product. 

A third state the machine could be in, would be if the machine is out of stock. It would no longer be able to dispense a product, so how to respond has changed. 


### In Java
1. We'll make some singleton state objects
2. We define our three states as new State objects. State.Idle would denote the idle state, state.HasOneDollar would denote the machine having one dollar, and state.OutOfStock would denote that this machine is out of stock. Our VendingMachine class would look like this in part, currentState refers to a specific state object, whichever denotes the current state of the vending machine. When the machine is instantiated with a stock count greater than zero, the current state is set to State.Idle. If the stock count is not greater than zero,
the current state is set to State.OutOfStock. Now, if we look at what happens when I insert a dollar, you can see that if the current state of the vending machine was State.Idle then the current state changes to State.HasOneDollar. If the currentState of the machine was already State.HasOneDollar, my money is returned and the currentState is set to State.Idle. If the currentState of the machine was already State.OutOfStock, my money is returned and the currentState stays in State.OutOfStock. 

```
final class State { // singleton objects for states
    private State() {}

    // all potential vending machine states as singletons
    public final static State Idle = new State();
    public final static State HasOneDollar = new State();
    public final static State OutOfStock = new State();
}
```

VendingMachine.java
```
public class VendingMachine {
    private State currentState;
    private int count;

    public vendingMachine(int count) {
        if (count > 0) {
            currentState = State.idle;
            this.count = count;
        } else {
            currentState = State.outOfStock;
            this.count = 0;
        }

        // handle insert dollar trigger
        public void insertDollar() {
            if (currentState == State.idle) {
                currentState = State.hasOneDollar;
            } else if (currentState == State.hasOneDollar) {
                doReturnMoney();
                currentState = State.idle;
            } else if (currentState == State.outOfStock) {
                doReturnMoney();
            }
        }
    }
}
```


## RESTRUCTURING THE ABOVE INTO STATE DESIGN PATTERN
We will define a state interface with a method for each trigger that a state needs to respond to. That is insertDollar, ejectMoney and dispense. And we'll have state classes that implement the state interface. One for each state needed, that is IdleState, HasOneDollarState and OutOfStockState. This is the state interface. State classes must implement the methods in this interface to respond to each trigger. 

State.java - *interface*
```
public interface State {
    public void insertDollar(VendingMachine vendingMachine);
    public void ejectMoney(VendingMachine vendingMachine);
    public void dispense(VendingMachine vendingMachine);
}
```

IdleState.java - *state class*
Our IdleState class now implements the State interface. When a dollar is inserted the insertDollar method is called, which then calls a set state method upon the vendingMachine object. This changes the current state of the machine to the HasOneDollarState. 
```
public class IdleState extends State {
    public void insertDollar(VendingMachine vendingMachine) {
        System.out.println("dollar inserted");

        vendingMachine.setState(vendingMachine.getHasOneDollarState());

        public void ejectMoney(VendingMachine vendingMachine) {
            System.out.println("no money to return");
        }

        public void dispense(VendingMachine vendingMachine) {
            System.out.println("payment required");
        }
    }
}
```

HasOneDollarState.java - *state class*
```
public class HasOneDollarState extends State {
    public void insertDollar(VendingMachine vendingMachine) {
        System.out.println("already have one dollar");

        vendingMachine.doReturnMoney();
        vendingMachine.setState(vendingMachine.getIdleState());
    }

    public void ejectMoney(VendingMachine vendingMachine) {
        System.out.println("returning money");

        vendingMachine.doReturnMoney();
        vendingMachine.setState(vendingMachine.getIdleState());
    }

    public void dispense(VendingMachine vendingMachine) {
        System.out.println("releasing product");

        if (vendingMachine.getCount() > 1) {
            vendingMachine.doReleaseProduct();
            vendingMachine.setState(vendingMachine.getIdleState());
        } else {
            vendingMachine.doReleaseProduct();
            vendingMachine.setState(vendingMachine.getOutOfStockState());
        }
    }
}
```

VendingMachine.java
The vendingmachine class constructor will instantiate each of the state classes. And the current state will refer to one of these state objects. The vendingmachine class would also have methods to handle the triggers as before, but now delegates handling to the current state object. Notice now, how much cleaner the code is, without having long conditionals in these methods. 
```
public class VendingMachine {
    private State idleState;
    private State hasOneDollarState;
    private State outOfStockState;

    private State currentState;
    private int count;

    public VendingMachine(int count) {
        // make the needed states
        idleState = new IdleState();
        hasOneDollarState = new hasOneDollarState();
        outOfStockState = new outOfStockState();

        if (count > 0) {
            currentState = idleState;
            this.count = count;
        } else {
            currentState = outOfStockState;
            this.count = 0;
        }
    }

    public void insertDollar() {
        currentState.insertDollar(this);
    }

    public void ejectMoney() {
        currentState.ejectMoney(this);
    }

    public void dispense() {
        currentState.dispense(this);
    }
}
```


In our example,the vending machine is the context class. It keeps track of it's current state. When a trigger occurs and a request is asked of a context object, it delegates to a state object to actually handle the request.

The state pattern is useful when you need to change the behavior of an object based upon changes to its internal state.
You can also use the pattern to simplify methods with long conditionals that depend on the object state. 