/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.categoryapp.resources;

import com.categoryapp.exceptions.ErrorMessage;
import com.categoryapp.exceptions.NotFoundException;
import com.categoryapp.resources.utils.ImageFileManager;
import java.io.File;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author thinh
 */
@Path("images")
public class ImagesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ImagesResource
     */
    public ImagesResource() {
    }
    
    @GET
    @Path("{filename}")
    @Produces({"image/png", "image/jpg", "image/gif"})
    public Response getJson(@PathParam("filename") String fileName) throws NotFoundException {
        //TODO return proper representation object
        ImageFileManager ifm = new ImageFileManager();
        File imageFile = new File(ifm.storageFilePath() + fileName);
        
        if (fileName == null || fileName.equals("") || !imageFile.exists()) {
            ErrorMessage errorMessage = new ErrorMessage(0, "Unable to find the image", "", Response.Status.NOT_FOUND);
            throw new NotFoundException(errorMessage);
        }
      
        Response.ResponseBuilder responseBuilder = Response.ok((Object) imageFile);
        responseBuilder.header("Content-Disposition", "attachment; filename=\"" + fileName +"\"");
        return responseBuilder.build();
    }
}
