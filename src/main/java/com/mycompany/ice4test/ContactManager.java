/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ice4test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yue Hou
 */
public class ContactManager{

    
    private List<Contact> contactList;

    // Constructor to initialize the contact list
    public ContactManager() {
        this.contactList = new ArrayList<>();
    }
    
    // Constructor that accepts a list of contacts (used for testing setup)
    public ContactManager(List<Contact> contactList) {
        this.contactList = contactList;
    }

    
    /*
	Locate a Contact record that matches the email address provided.
	Returns the Contact record if found, null if not found.
    */
    public Contact findContact(String emailAddress) {
        if (contactList.isEmpty()){
            throw new RuntimeException("Cannot find contact. The contact list is empty.");
        }
       
        for (Contact contact : contactList) {
            if (contact.getEmailAddress().equals(emailAddress.trim())) {
                return contact;
            }
        }
        return null; 
    }

    /*
	 Removes all contacts from the list
    */
    public void clearContacts() {
        this.contactList.clear();
    }

}


