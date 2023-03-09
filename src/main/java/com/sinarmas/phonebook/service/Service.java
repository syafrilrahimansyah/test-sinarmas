package com.sinarmas.phonebook.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinarmas.phonebook.persistence.entity.Contact;

import java.util.List;

public interface Service {
    List<Contact> getAllContact();
    List<Contact> getByNumber(String number);
    Contact getById(String id);
    String create(Contact contact) throws JsonProcessingException;
    String delete(String id) throws JsonProcessingException;
    String update(String id, Contact contact) throws JsonProcessingException;
}
