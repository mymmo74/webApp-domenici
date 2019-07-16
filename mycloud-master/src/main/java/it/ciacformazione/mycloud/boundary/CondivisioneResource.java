/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.mycloud.boundary;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Path;

/**
 *
 * @author tss
 */
@RolesAllowed({"users"})
@Path("/shares")
public class CondivisioneResource {
    /* TODO
    Implementazione di una serie di servizi per:
    - elenco documenti condivisi da un utente
    - rendere documento condiviso ad un utente
    - eliminare condivisione
    */
}
