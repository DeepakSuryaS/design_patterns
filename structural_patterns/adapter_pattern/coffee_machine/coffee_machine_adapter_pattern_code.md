### You are working in an office with an old coffee machine that dispenses two different coffee flavours. 
### However, the new boss wants to add a new coffee machine with a touchscreen that can also connect to the old coffee machine. 
### Provide code to add an adapter so that the new touchscreen will to work with the old coffee machine.

---
### _CoffeeMachineInterface.java_
```
public class CoffeeMachineInterface {
    public void chooseFirstSelection();
    public void chooseSecondSelection();
}
```
---
### _OldCoffeeMachine.java_
```
public class OldCoffeeMachine {
    public void selectA() {
        System.out.println("Selected A");
    }
    public void selectB() {
        System.out.println("Selected B");
    }
}
```
---
### _CoffeeTouchScreenAdapter.java_
```
public class CoffeeTouchScreenAdapter {
    OldCoffeeMachine theMachine;
    public CoffeeTouchScreenAdapter(OldCoffeeMachine newMachine) {
        theMachine = newMachine;
    }
    public void chooseFirstSelection() {
        theMachine.selectA();
    }
    public void chooseSecondSelection() {
        theMachine.selectB();
    }
}
```

