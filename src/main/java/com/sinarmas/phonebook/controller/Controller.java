package com.sinarmas.phonebook.controller;

import com.sinarmas.phonebook.Constant;
import com.sinarmas.phonebook.controller.entity.Response;
import com.sinarmas.phonebook.persistence.entity.Contact;
import com.sinarmas.phonebook.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@CrossOrigin
@RestController
@RequestMapping(path = "/")
public class Controller {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Service service;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll(
    ) {
        try {
            List<Contact> contactList = service.getAllContact();
            Response response = new Response();
            response.setMessage(Constant.SUCCESS_READ);
            response.setStatus(Constant.GET_SUCCESS);
            response.setData(contactList);
            return response;
        }catch (Exception e){
            Response response = new Response();
            response.setMessage(e.getMessage());
            response.setStatus(Constant.GET_ERROR);
            return response;
        }
    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response create(@RequestBody Contact contact
    ) {
        try {
            String data = service.create(contact);
            Response response = new Response();
            response.setMessage(Constant.SUCCESS_CREATE);
            response.setStatus(Constant.POST_SUCCESS);
            response.setData(data);
            return response;
        }catch (Exception e){
            Response response = new Response();
            response.setMessage(e.getMessage());
            response.setStatus(Constant.POST_ERROR);
            return response;
        }
    }
    @GetMapping(path = "/get-by-number", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getByNumber(@RequestParam("number") String number
    ) {
        try {
            List<Contact> contactList = service.getByNumber(number);
            Response response = new Response();
            response.setMessage(Constant.SUCCESS_READ);
            response.setStatus(Constant.GET_SUCCESS);
            response.setData(contactList);
            return response;
        }catch (Exception e){
            Response response = new Response();
            response.setMessage(e.getMessage());
            response.setStatus(Constant.GET_ERROR);
            return response;
        }
    }
    @GetMapping(path = "/get-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getById(@RequestParam("id") String id
    ) {
        try {
            Contact contactList = service.getById(id);
            Response response = new Response();
            response.setMessage(Constant.SUCCESS_READ);
            response.setStatus(Constant.GET_SUCCESS);
            response.setData(contactList);
            return response;
        }catch (Exception e){
            Response response = new Response();
            response.setMessage(e.getMessage());
            response.setStatus(Constant.GET_ERROR);
            return response;
        }
    }
    @PutMapping(path = "/get-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestParam(name = "id") String id, @RequestBody Contact contact
    ) {
        try {
            String data = service.update(id,contact);
            Response response = new Response();
            response.setMessage(Constant.SUCCESS_UPDATE);
            response.setStatus(Constant.PUT_SUCCESS);
            response.setData(data);
            return response;
        }catch (Exception e){
            Response response = new Response();
            response.setMessage(e.getMessage());
            response.setStatus(Constant.PUT_ERROR);
            return response;
        }
    }
    @DeleteMapping(path = "/get-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam(name = "id") String id
    ) {
        try {
            String data = service.delete(id);
            Response response = new Response();
            response.setMessage(Constant.SUCCESS_DELETE);
            response.setStatus(Constant.DELETE_SUCCESS);
            response.setData(data);
            return response;
        }catch (Exception e){
            Response response = new Response();
            response.setMessage(e.getMessage());
            response.setStatus(Constant.DELETE_ERROR);
            return response;
        }
    }
}
