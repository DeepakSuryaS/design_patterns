package com.example.sharingapp;

import android.content.Context;

public class DeleteContactCommand extends Command {
    private final ContactList myContactList;
    private final Contact myContact;
    private final Context myContext;

    public DeleteContactCommand(ContactList contactList, Contact contact, Context context) {
        this.myContactList = contactList;
        this.myContact = contact;
        this.myContext = context;
    }

    @Override
    public void execute() {
        myContactList.deleteContact(myContact);
        setIsExecuted(myContactList.saveContacts(myContext));
    }
}
