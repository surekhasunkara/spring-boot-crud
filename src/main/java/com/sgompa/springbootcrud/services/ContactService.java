package com.sgompa.springbootcrud.services;

import com.sgompa.springbootcrud.entities.Contact;
import com.sgompa.springbootcrud.repos.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService{
    @Autowired
    ContactRepo contactRepo;

    @Override
    public Contact saveContact(Contact contact) {
        if(contact.getFirstName() == null || contact.getFirstName().isEmpty()){
            return new Contact();
        }
        return contactRepo.save(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        contactRepo.save(contact);
    }

    @Override
    public Contact deleteContact(int contactId) {
        Contact con = contactRepo.getById(contactId);
        contactRepo.delete(con);
        return con;
    }

    @Override
    public Contact getContactById(int contactId) {
        return contactRepo.findContactsById(contactId);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }
}
