/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baruzzi.services;

import baruzzi.business.GiocatoreStore;
import baruzzi.entity.Giocatore;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("giocatore")
public class GiocatoriResource {
    
    @Inject
    GiocatoreStore store;
    
    @GET
    public List<Giocatore> findAll() {
        return store.all();
    }
    
        
    @GET
    @Path("{id}")
    // "./resources/tags/2 "   <--- esempio
    public Giocatore find(@PathParam("id") int id){
        return store.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Giocatore gioc) {
         store.create(gioc);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void update(@PathParam("id") int id,Giocatore gioc){
        // se id esiste nel DB faccio un aggiornamento
        // altrimenti lo creo nuovo
        gioc.setId(id);
        store.save(gioc);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id){
        store.remove(id);
    }
}
