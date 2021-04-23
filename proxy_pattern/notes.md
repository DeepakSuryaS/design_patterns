The proxy acts as a simplified or lightweight version of the original object. A proxy object is still able to accomplish the same tasks,
but may delegate requests to the original object to achieve them.

Examples: crash dummies, credit cards etc.

This is the goal of the proxy design pattern, which allows a proxy class to represent a real subject class.

In this design pattern, the proxy class wraps the real subject class, i.e., hides a reference to an instance of the real subject class.

The real subject class may contain sensitive information or would be resource intensive to instantiate.

### The three most common scenarios for them are:
1. One, to act as a virtual proxy where the proxy class is used in place of a real subject class, that is resource intensive to instantiate. This is commonly used on images, and web pages, or graphics editors, because a single high definition image can be extremely large. 
2. Two, to act as a protection proxy in order to control access to the real subject class. A protection proxy can be used in a learning management system that checks the credentials of a user. So the different users, like students and instructors, can only access the appropriate functions permitted by their role. 
3. And three, to act as a remote proxy, where the proxy class is local and the real subject class exists remotely. 


The proxy class wraps and may delegate or redirect calls upon it, to the real object class. However, not all calls get delegated because the proxy class is supposed to act as a lighter version of the real subject class and can do some of its later responsibilities. The proxy class will only redirect more substantive requests to the real subject class.

### But, what calls need to be supported in the proxy class?
Since the proxy class is meant to stand in for the real subject class, it must offer the same methods. You can ensure that by having both these classes implement a common subject interface, which also allows for polymorphism. Since the proxy and real subject classes are both sub-types of subject, a client class can interact with the proxy, which will have the same expected interface as the real subject. 


1. Proxy and RealSubject are subtypes of Subject.
2. This design pattern achieves polymorphism through implementing a Subject interface.


Real world example:
Think of an online retail store. How will you know which warehouse to route the orders to fulfill customer orders? You may run into an issue where you route orders to a warehouse that doesn't have stock. So you need an appropriate system that determines which warehouse to choose.
You can use a Proxy to maintain a list of warehouse and their inventories. Based on the inventories reported by the warehouses to the Proxy, the proxy will choose the warehouse.


### Procedure
Step 1: Design the subject interface
Create the interface that client software will use to interact with your system.
This interface will be implemented by the order fulfillment and warehouse classes. 
```
public interface IOrder {
    public void fulfillOrder(Order);
}
```

Step 2: Implement the RealSubject class
The warehouse class knows how to process an order for fulfillment, and it knows how to report the current stock of items.
Notice that it doesn't need to check if it has enough stock to fulfill an order, because an order should only be sent to a warehouse if it can be fulfilled. 
```
public class Warehouse implements IOrder {
    private Hashtable<String, Integer> stock;
    prive String address;

    /* Constructors and other attributes would go here */

    public void fulfillOrder(Order order) {
        for(Item item : order.itemList) {
            this.stock.replace(item.sku, stock.get(item) - 1);
        }

        /* Process the order for shipment and delivery */
    }

    public int currentInventory(Item item) {
        if (stock.containsKey(item.sku)) {
            return stock.get(item.sku).intValue();
        }

        return 0;
    }
}
```

Step 3: Implement the Proxy class
The order fulfillment class does all the work of checking the warehouse inventory and ensuring that an order can be successfully
completed before sending the request to the warehouse. It will ask each warehouse about whether it has enough stock of a particular item.
If the warehouse has enough inventory, the item gets added to a new order object that will be sent to the warehouse. The proxy class ensures that an order can be fulfilled before sending the request to your warehouses. This protects your warehouse system from receiving orders it cannot fulfill. The order fulfillment class also lets you separate order validation from the order fulfillment by separating them into two pieces. This will improve the overall rate of processing an order because the warehouse doesn't have to worry about the validation process. Each individual warehouse also doesn't need to worry about how to reroute an order if the warehouse can't fulfill the order. 
```
public class OrderFulfillment implements IOrder {
    private List<Warehouse> warehouses;

    /* Constructors and other attributes would go here */

    public void fulfillOrder(Order order) {
        /* For each item in customer order, check each warehouse to see if it is in stock.
        If yes, then create a new Order for that warehouse. Else check the next warehouse.

        Send all the orders to the warehouse(s) after you finish iterating over all the items in the original order */
        for (Item item : order.itemList) {
            for (Warehouse warehouse : warehouses) {
                ...
            }
        }
        return;
    }
}
```



The order fulfillment class can be improved with other functionalities, such as, prioritizing sending orders to warehouses based on proximity to the customer to ensure that orders arrive as fast as possible.

The proxy design pattern is useful when you need to defer creating resource intensive objects until needed, control access to specific objects, or when you need something to act as a local representation of a remote system.

To summarize, the main features of the proxy design pattern are: 
1. to use the proxy class to wrap the real subject class, 
2. to have a polymorphic design so that the client class can expect the same interface for the proxy and real subject classes,
3. to use a lightweight proxy in place of a resource intensive object until it is actually needed, 
4. to implement some form of intelligent verification of requests from client code in order to determine if, how, and to whom the requests should be forwarded to,
5. and to present a local representation of a system that is not in the same physical or virtual space. The proxy design pattern provides your system with a powerful means of indirection.


Proxy classes are robust and can let you build systems that are more secure and less resource-intensive. 