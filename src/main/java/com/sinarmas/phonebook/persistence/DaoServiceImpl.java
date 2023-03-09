package com.sinarmas.phonebook.persistence;

import com.sinarmas.phonebook.persistence.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DaoServiceImpl implements DaoService{
    @Autowired
    private Repository repository;

    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Contact> getByNumber(String number) {
        return repository.getByNumber(number);
    }

    @Override
    public Contact getById(String id) {
        return repository.getById(id);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void create(Contact contact) {
        repository.save(contact);
    }

    @Override
    public void update(String id, Contact contact) {
        repository.deleteById(id);
        repository.save(contact);
    }
}
