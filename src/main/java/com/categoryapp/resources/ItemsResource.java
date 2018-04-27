/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.categoryapp.resources;

import com.categoryapp.domains.Category;
import com.categoryapp.domains.Database;
import com.categoryapp.domains.Item;
import com.categoryapp.exceptions.ErrorMessage;
import com.categoryapp.exceptions.MissingParamException;
import com.categoryapp.resources.utils.ImageFileManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * REST Web Service
 *
 * @author thinh
 */
@Path("items")
public class ItemsResource {

    @Context
    private UriInfo context;
    
    public ItemsResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItems() {
        List<Item> items = Database.getInstance().getAllItems();
        GenericEntity<List<Item>> genericEntity = new GenericEntity<List<Item>>(items){};
        return Response.status(200).entity(genericEntity).build();
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postItem(@FormDataParam("category_id") Integer categoryId,
                             @FormDataParam("file") InputStream inputStream,
                             @FormDataParam("file") FormDataContentDisposition fileDetail,
                             @FormDataParam("crafted") Integer crafted) throws IOException {
        
        Item item = new Item();
        
        if (crafted == null) {
            ErrorMessage errorMessage = new ErrorMessage(100, "Missing crafted parameter", "", Response.Status.BAD_REQUEST);
            throw new MissingParamException(errorMessage);
        }
        
        Category category = Database.getInstance().categoryById(categoryId);
        item.setCategory(category);
        item.setCrafted(crafted == 0 ? false : true);
        
        if (inputStream != null && fileDetail != null) {
            ImageFileManager ifm = new ImageFileManager();
            String fileName = fileDetail.getFileName();
            String fileExtension = ifm.getFileExtension(fileName);
            
            String randomFileName = UUID.randomUUID().toString() + "." + fileExtension;
            ifm.writeFileToDisk(inputStream, randomFileName, true);
            
            String imageURI = context.getBaseUri().toString() + "images/" + randomFileName;
            item.setImageUrl(imageURI);
        }
        
        // Save to database
        Database.getInstance().addItem(item);
        
        return Response.status(200).entity(item).build();
    }
}
