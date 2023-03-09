package com.sinarmas.phonebook.controller.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Response {
    private String requestId = UUID.randomUUID().toString();
    private String status;
    private String message;
    private Object data;
}
