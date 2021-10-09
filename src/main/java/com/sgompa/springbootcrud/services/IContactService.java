package com.sgompa.springbootcrud.services;

import com.sgompa.springbootcrud.entities.Contact;

import java.util.List;

public interface IContactService {

    Contact saveContact(Contact contact);
    void updateContact(Contact contact);
    Contact deleteContact(int contactId);
    Contact getContactById(int contactId);
    List<Contact> getAllContacts();
}
