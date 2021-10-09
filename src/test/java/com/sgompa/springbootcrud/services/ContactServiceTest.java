package com.sgompa.springbootcrud.services;

import com.sgompa.springbootcrud.entities.Contact;
import com.sgompa.springbootcrud.repos.ContactRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {
    @InjectMocks
    ContactService contactService;
    @Mock
    ContactRepo contactRepo;

    private Contact contact;

    @BeforeEach
    void setMockOutput() {

    }


    @Test
    void createContact() {
        contact = new Contact(1,"Sam","Beau","8970889", "SF");
        when(contactRepo.save(contact)).thenReturn(contact);
        Contact result = contactService.saveContact(contact);
        assertEquals(1,result.getId());
        assertEquals("Sam",result.getFirstName());
        assertEquals("Beau",result.getLastName());
        assertEquals("8970889",result.getPhoneNumber());
        assertEquals("SF",result.getCity());
    }

    @Test
    void createContact1(){
        Contact contact = new Contact(2,null,"","", "");
        Contact result = contactService.saveContact(contact);
        assertEquals(0,result.getId());
        assertEquals(null,result.getFirstName());
        assertEquals(null,result.getLastName());
        assertEquals(null,result.getPhoneNumber());
        assertEquals(null,result.getCity());
    }

    @Test
    void getAllContacts() {
    }

    @Test
    void getContactById() {
    }

    @Test
    void updateContact() {
    }

    @Test
    void deleteContact() {
    }
}