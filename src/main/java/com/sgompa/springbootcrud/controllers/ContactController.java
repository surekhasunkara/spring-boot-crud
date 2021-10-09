package com.sgompa.springbootcrud.controllers;

import com.sgompa.springbootcrud.entities.Contact;
import com.sgompa.springbootcrud.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ContactController {
    @Autowired
    ContactService contactService;

    @PostMapping(value="contacts/")
    public void createContact(@RequestBody Contact contact){
        contactService.saveContact(contact);
    }
    @GetMapping(value="contacts/", produces = "application/json")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }
    @GetMapping(value="contacts/{contactId}", produces = "application/json")
    public Contact getContactById(@PathVariable int contactId){
        return contactService.getContactById(contactId);
    }
    @PutMapping(value="contacts/")
    public  void updateContact(@RequestBody Contact contact){
        contactService.updateContact(contact);
    }
    @DeleteMapping(value="/contacts/{contactId}")
    public void deleteContact(@PathVariable int contactId){
        contactService.deleteContact(contactId);
    }
}
