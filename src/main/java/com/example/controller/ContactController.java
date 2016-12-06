package com.example.controller;

import com.example.dto.ContactDto;
import com.example.model.Contact;
import com.example.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/get/{contactId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContactDto getContact(@PathVariable(value = "contactId") Long contactId) {
        return contactService.getContact(contactId);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createContact(@RequestBody ContactDto dto) {
        contactService.saveContact(dto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateContact(@RequestBody ContactDto dto) {
        contactService.updateContact(dto);
    }

    @RequestMapping(value = "/del/{contactId}", method = RequestMethod.DELETE)
    public void deleteContact(@PathVariable(value = "contactId") Long contactId) {
        contactService.deleteContact(contactId);
    }

    @RequestMapping(value = "/getByUser/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContactDto> getContactsByUser(@PathVariable(value = "userId") Long userId) {
        return contactService.getAllContactByUser(userId);
    }

}
