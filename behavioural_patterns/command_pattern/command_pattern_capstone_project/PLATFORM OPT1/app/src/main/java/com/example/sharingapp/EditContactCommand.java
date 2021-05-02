package com.example.sharingapp;

import android.content.Context;

public class EditContactCommand extends Command {
    private final ContactList myContactList;
    private final Contact myOldContact;
    private final Contact myNewContact;
    private final Context myContext;

    public EditContactCommand(ContactList contactList, Contact oldContact, Contact newContact, Context context) {
        this.myContactList = contactList;
        this.myOldContact = oldContact;
        this.myNewContact = newContact;
        this.myContext = context;
    }

    @Override
    public void execute() {
        myContactList.deleteContact(myOldContact);
        myContactList.addContact(myNewContact);
        setIsExecuted(myContactList.saveContacts(myContext));
    }
}
