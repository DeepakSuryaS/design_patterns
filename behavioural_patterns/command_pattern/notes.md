It's like a boss and a secretary.
The boss is extremely busy. He has a lot of things to do. So, he writes them down and gives it to his secretary. The secretary then assigns the jobs to separate people. This way, the boss doesn't need to know about the people and the tasks that they'll given.


Similarly, in software, a sender object creates a command object. 

But what actually makes the command object do what it's supposed to do and invoke the specific receiver object to complete the task?
This is where an invoker comes in. The command pattern has another object that invokes the command objects to complete whatever task it is supposed to do, called the invoker. 

THE INVOKER IS THE SECRETARY.


So, where can you implement the command pattern in your software?
1. One purpose of using the command pattern is to store and schedule different requests. 
      1. When an object calls a method of another object, you can't really do anything to the method calls. Turning the different requests in your software into command objects can allow you to treat them as the way you would treat other objects. You can store these command objects into lists, you can manipulate them before they are completed, or you can put them onto a queue so that you can schedule different commands to be completed at different times. For example, you can use the command pattern to have an alarm ring in calendar software. When an event is created in the calendar, a command object could be created to ring the alarm. This command could be put onto a queue, so that the command can be completed later when the event is actually scheduled to occur.
2. Another important purpose of the command pattern is allowing commands to be undone or redone. Like how you can undo or redo edits in a document. 
      1. Suppose that you are creating text editing software. There can be many different commands that can be executed in your text editing software like delete text, change font, pixel text and so on. To achieve redo and undo functionality, your software will need two lists, a history list which holds all the commands that have been executed, and a redo list which would be used to put commands that have been undone. Every time a command is requested, a command object is created and executed. Every time a command is completed, that command goes to the history list. Now, what if the user wanted to undo a command? Well, the software would look at the history list and look at the most recent command executed. The software would ask this command to undo itself and then put it on the redo list. Let's undo another command. If the user needs to redo, the software would take the most recent command undone in the redo list and ask the command to execute again. Then move it onto the history list again. Let's redo another command. The redo list will also need to be emptied every time a command is executed. Because usually, you can't redo a previous edit after a new edit has already been made. So, that's how you can use the command pattern to create your text editing software. This redo/undo functionality doesn't have to be just for text editors. You can use a command pattern to allow redo/undo on any type of application. 


The important thing is that the command pattern lets you do things to request that you wouldn't be able to do if they were simple method calls from one object to the other. You can store these commands in a log list also. So that if your software program has an unexpected crash, you can allow your users to redo all the recent commands. Creating these requests as objects allows you to create very useful functionality in your software programs. 