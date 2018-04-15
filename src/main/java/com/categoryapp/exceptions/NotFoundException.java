/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.categoryapp.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author thinh
 */
public class NotFoundException extends WebApplicationException {
    
    /**
    * Create a HTTP 404 (Not Found) exception.
    * @param message the String that is the entity of the 404 response.
    */
    public NotFoundException(ErrorMessage message) {
        super(Response.status(Response.Status.NOT_FOUND).
        entity(message.toJSON()).type("application/json").build());
    }  
}
