### What are the two conditions required for you to use the facade design pattern?
1. You need to simplify the interaction with your subsystem for client classes.
2. You need a class to act as an interface between your subsystem and a client class.

### What are the key design principles used to implement facade design pattern?
Encapsulation, information hiding, separation of concerns.


_While the facade pattern uses a number of design principles, it's purpose is to provide ease of access to a complex subsystem. This is done by encapsulating the subsystem classes into a facade class, and then hiding them from the client classes so that the clients do not know about the details of the subsystem._


### Summary:
#### The facade design pattern:
1. Is a means to hide the complexity of a subsystem by encapsulating it behind a unifying wrapper called a facade class.
2. Removes the need for client classes to manage a subsystem on their own, resulting in less coupling between the subsystem and client classes.
3. Handles instantiation and redirection of tasks to the appropriate class within the subsystem.
4. Provides client classes with a simplified interface for the subsystem.
5. Acts simply as a point of entry to a subsystem and does not add more functionality to the subsystem.


### Process:
1. Design the interface.
	This interface is the one that will be implemented by different account classes and will not be known to the customer class.
2. Implement the interface with one or more classes.
3. Create the facade class and wrap the classes that implement the interface.
4. Use the facade class to access the subsystem.

## Program

Step 1: Design the interface

```
public interface IAccount {
	public void deposit(BigDecimal amount);
	public void withDraw(BigDecimal amount);
	public void transfer(BigDecimal amount);
	public int getAccountNumber();
}
```


Step 2: Implement the interface with one or more classes

```
public class Chequing implements IAccount { ... }
public class Saving implements IAccount { ... }
public class Investment implements IAccount { ... }
```

Step 3: Create the facade class and wrap the classes that implement the interface

```
public class BankService {

	private HashTable<int, IAccount> bankAccounts;

	public bankService() {
		this.bankAccounts = new HashTable<int, IAccount>;
	}

	public int createNewAccount(String type, BigDecimal initAmount) {
		IAccount newAccount = null;
		
		switch (type) {
			case "chequing":
				newAccount = new Chequing(initAmount);
				break;
			case "saving":
				newAccount = new Saving(initAmount);
				break;
			case "investment":
				newAccount = new Investment(initAmount);
				break;
			default:
				System.out.println("Invalid Account Type.");
				break;
		}

		if (newAccount != null) {
			this.bankAccounts.put(newAccount.getAccountNumber(), newAccount);
			return newAccount.getAccountNumber();
		}

		return -1;
	}

	public void transferMoney(int to, int from, BigDecimal amount) {
		IAccount toAccount = this.bankAccounts.get(to);
		IAccount fromAccount = this.bankAccounts.get(from);
		fromAccount.transfer(toAccount, amount);
	}
}
```

In the above facade class, the access modifier for each account is private. Since the point of the facade pattern is to hide complexity, we use the information hiding design principle to prevent all client classes from seeing the account objects and how these accounts behave.


Step 4: Use the facade class to access the subsystem

```
public class Customer {
	public static void main(String args[]) {

		BankService myBankService = new BankService();
		int mySaving = myBankService.createNewAccount("saving", new BigDecimal(500.00));
		int myInvestment = myBankService.createNewAccount("investment", new BigDecimal(1000.00));
		myBankService.transferMoney(mySaving, myInvestment, new BigDecimal(300.00));

	}
}
```


Done. Now, the customer doesn't need to worry about creating his own accounts and managing them, they just need to know the bank service and the set of behaviours the bank service is capable of performing. Thus, we've effectively hidden the complexity of account management from the customer using the facade design pattern.



