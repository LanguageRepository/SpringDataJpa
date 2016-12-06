package com.example.service;

import com.example.dto.ContactDto;
import com.example.model.Contact;
import com.example.repository.ContactRepository;
import com.example.utils.ContactUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactUtils contactUtils;

    @Transactional
    public ContactDto getContact(Long id) {
        Contact contact = contactRepository.getOne(id);
        return contactUtils.convertEntityToDto(contact);
    }

    @Transactional
    public void saveContact(ContactDto dto) {
        contactRepository.save(contactUtils.convertDtoToEntity(dto));
    }

    @Transactional
    public void updateContact(ContactDto dto) {
        contactRepository.saveAndFlush(contactUtils.convertDtoToEntity(dto));
    }

    @Transactional
    public void deleteContact(Long id) {
        contactRepository.delete(id);
    }

    @Transactional
    public List<ContactDto> getAllContactByUser(Long id) {
        return contactUtils.convertEntitiesToDtos(contactRepository.findByUserId(id));
    }

}
