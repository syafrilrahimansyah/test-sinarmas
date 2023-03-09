package com.sinarmas.phonebook.persistence;


import com.sinarmas.phonebook.persistence.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repository extends JpaRepository<Contact, String> {
    @Query(value = "SELECT * FROM contact WHERE number like %?1%",nativeQuery = true)
    List<Contact> getByNumber(String number);

    @Query(value = "SELECT * FROM contact WHERE id = ?1",nativeQuery = true)
    Contact getById(String id);
}
