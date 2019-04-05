/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.AnagraficaStore;
import it.ciacformazione.nostalciac.business.CorsoStore;
import it.ciacformazione.nostalciac.business.EsperienzaStore;
import it.ciacformazione.nostalciac.entity.Anagrafica;
import it.ciacformazione.nostalciac.entity.Corso;
import it.ciacformazione.nostalciac.entity.Esperienza;
import it.ciacformazione.nostalciac.entity.Tag;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
public class AnagraficaResource {
    
    @Inject
    AnagraficaStore store;

    @Inject
    EsperienzaStore esperienzaStore;

    @Inject
    CorsoStore corsoStore;
    
    @Context
    ResourceContext rc;

    @PathParam("id")
    private Integer id;

    @GET
    public Anagrafica find() {
        return store.find(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Anagrafica a) {
        a.setId(id);
        store.save(a);
    }

    @DELETE
    public void delete() {
        store.remove(id);
    }

    @Path("esperienze")
    public EsperienzeResource esperienze() {
        EsperienzeResource resource = rc.getResource(EsperienzeResource.class);
        resource.setIdAnagrafica(id);
        return resource;
    }

    @GET
    @Path("corsi")
    public List<Corso> corsi(){
        return store.corsi(id);
    }
    
    @PUT
    @Path("corsi")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCorsi(List<Integer> ids){
        Anagrafica finded = store.find(id);
        Set<Corso> tosave = ids.stream()
                .map(c -> corsoStore.find(c))
                .collect(Collectors.toSet());
        finded.setCorsi(tosave);
        store.save(finded);
    }

}
