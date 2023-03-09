package com.sinarmas.phonebook.persistence;

import com.sinarmas.phonebook.persistence.entity.Contact;
import java.util.List;

public interface DaoService {
    List<Contact> getAll();
    List<Contact> getByNumber(String number);
    Contact getById(String id);
    void delete(String id);
    void create(Contact contact);
    void update(String id, Contact contact);
}
