package com.sinarmas.phonebook.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinarmas.phonebook.Constant;
import com.sinarmas.phonebook.persistence.DaoService;
import com.sinarmas.phonebook.persistence.entity.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceImpl extends CommonService implements Service {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DaoService daoService;

    @Override
    public List<Contact> getAllContact() {
        return daoService.getAll();
    }

    @Override
    public List<Contact> getByNumber(String number) {
        return daoService.getByNumber(number);
    }

    @Override
    public Contact getById(String id) {
        return daoService.getById(id);
    }

    @Override
    public String create(Contact contact) throws JsonProcessingException {
        try {
            if (contact.getNumber().matches(".*[a-zA-Z]+.*")) {
                return Constant.ERROR_NUMBER_1;
            } else {
                daoService.create(contact);
                return Constant.SUCCESS_CREATE;
            }
        } catch (Exception e) {
            logger.info(generateJson(e));
            return Constant.ERROR_CREATE;
        }
    }

    @Override
    public String delete(String id) throws JsonProcessingException {
        try {
            daoService.delete(id);
            return Constant.SUCCESS_DELETE;
        } catch (Exception e) {
            logger.info(generateJson(e));
            return Constant.ERROR_DELETE;
        }
    }

    @Override
    public String update(String id, Contact contact) throws JsonProcessingException {
        try {
            daoService.update(id, contact);
            return Constant.SUCCESS_UPDATE;
        } catch (Exception e) {
            logger.info(generateJson(e));
            return Constant.ERROR_UPDATE;
        }
    }
}
