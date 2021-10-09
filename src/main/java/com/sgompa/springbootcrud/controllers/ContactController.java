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
    public Contact createContact(@RequestBody Contact contact){
        return contactService.saveContact(contact);
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
    public String updateContact(@RequestBody Contact contact){
        contactService.updateContact(contact);
        return new String("contact updated.");
    }
    @DeleteMapping(value="/contacts/{contactId}")
    public Contact deleteContact(@PathVariable int contactId){

        return contactService.deleteContact(contactId);
    }
}
