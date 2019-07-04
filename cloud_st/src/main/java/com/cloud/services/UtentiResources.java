/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.services;

import com.cloud.business.UtenteStore;
import com.cloud.entity.Utente;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author tss
 */
@Path("/utenti")
public class UtentiResources {
        @Inject
        UtenteStore store;
    
    @Context
    ResourceContext rc;
    
    @GET
    public List<Utente> findAll(){
        return store.findAll();
    }
    
    @Path("{id}")
    public AnagraficaResource find(@PathParam("id") int id) {
        AnagraficaResource resource = rc.getResource(AnagraficaResource.class);
        resource.setId(id);
        return resource;
    }    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Anagrafica a, @Context UriInfo uriInfo) {
        Anagrafica saved = store.save(a);
        URI uri = uriInfo.getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();
        return Response.ok(uri).build();
        
    }
}
