### What type of class is the adapter an example of?
Wrapper class.

### What are the characteristics of the adapter design pattern?
1. The client and the adaptee classes have incompatible interfaces.
2. An adapter is a wrapper class that hides the adaptee, hiding it from the client.
3. The client sends requests indirectly to the adaptee by using the adapter's target interface.
4. The adapter translates the request sent by the client class into a request that the adaptee class is expecting.
5. Reuse an existing adaptee with an incompatible interface.

_The adapter encapsulates the adaptee and presents a new interface, or appearance to the client class. It does this by wrapping the adaptee's interface and exposing a new target interface that makes sense to the client._


### Process:
1. Design the target interface.
   1. You create a target interface that your adapter class will be implementing for your client class to use.
2. Implement the target interface with the adapter class.
3. Send the request from the client to the adapter using the target interface.



## Program
Step 1: Design the target interface

```
public interface WebRequester {
    public int request(object);
}
```

Step 2: Implement the target interface with the adapter class

```
public class WebAdapter implements WebRequester {
    private WebService service;

    public void connect(Webservice currentService) {
        this.service = currentService;
    }

    public int request(Object request) {
        Json result = this.toJson(request);
        Json response = service.request(result);

        if (response != null) {
            return 200; // ok status code
        }

        return 500; // server error status code
    }

    private Json toJson(Object input) { ... }
}
```

Step 3: Send the request from the client to the adapter using the target interface

```
public class WebClient {
    private WebRequester webRequester;

    public Webclient(WebRequester webRequester) {
        this.webRequester = webRequester;
    }

    private Object makeObject() { ... } // make an object

    public void doWork() {
        Object object = makeObject();
        int status = webRequester.request(object);

        if (status == 200) {
            System.out.println("OK");
        } else {
            System.out.println("Not OK");
        }

        return;
    }
}
```


Step 4: Main program

```
public class Program {
    public static void main(String args[]) {
        String webHost = "Host: https://google.com\n\r";
        WebService webService = new WebService(webHost);
        WebAdapter adapter = new WebAdapter();
        adapter.connect(service);
        WebClient client = new WebClient(adapter);
        client.doWork();
    }
}
```