package com.example.sharingapp;

import android.content.Context;

public class AddContactCommand extends Command {
    private final ContactList myContactList;
    private final Contact myContact;
    private final Context myContext;

    public AddContactCommand(ContactList contactList, Contact contact, Context context) {
        this.myContactList = contactList;
        this.myContact = contact;
        this.myContext = context;
    }

    @Override
    public void execute() {
        myContactList.addContact(myContact);
        setIsExecuted(myContactList.saveContacts(myContext));
    }
}
