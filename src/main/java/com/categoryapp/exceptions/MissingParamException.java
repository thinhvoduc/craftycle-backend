/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.categoryapp.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author thinh
 */
public class MissingParamException extends WebApplicationException {
    /**
    * Create a HTTP 400 (Bad Request) exception.
    * @param message the String that is the entity of the 401 response.
    */
    public MissingParamException(ErrorMessage message) {
        super(Response.status(Response.Status.BAD_REQUEST).
        entity(message.toJSON()).type(MediaType.APPLICATION_JSON).build());
    }
}
