package com.example.utils;

import com.example.dto.ContactDto;
import com.example.model.Contact;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ContactUtils {

    @Autowired
    private UserRepository userRepository;

    public ContactDto convertEntityToDto(Contact contact) {
        ContactDto dto = new ContactDto();
        dto.setId(contact.getId());
        dto.setName(contact.getName());
        dto.setDescription(contact.getDescription());
        dto.setPhone(contact.getPhone());
        dto.setUserId(contact.getUser().getId());
        return dto;
    }

    public Contact convertDtoToEntity(ContactDto dto) {
        Contact contact = new Contact();
        Date curTime = new Date();
        contact.setId(dto.getId());
        contact.setDescription(dto.getDescription());
        contact.setName(dto.getName());
        contact.setPhone(dto.getPhone());
        contact.setUser(userRepository.getOne(dto.getUserId()));
        contact.setCreateDate(curTime);
        return contact;
    }
    
    public List<ContactDto> convertEntitiesToDtos(List<Contact> contacts) {
        List<ContactDto> dtos = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            ContactDto dto = new ContactDto();
            dto.setId(contacts.get(i).getId());
            dto.setName(contacts.get(i).getName());
            dto.setDescription(contacts.get(i).getDescription());
            dto.setPhone(contacts.get(i).getPhone());
            dto.setUserId(contacts.get(i).getUser().getId());
            dtos.add(dto);
        }
        return dtos;
    }

}
