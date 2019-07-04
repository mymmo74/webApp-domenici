/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.cloud.business;

import it.ciacformazione.cloud.entity.Utente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class UtenteStore {
    
    @PersistenceContext()
    EntityManager em;
    
    /**
     * Restituisce tutti gli Utenti da DB
     *
     * @return tutti gli Utenti
     */
    public List<Utente> all() {
        return em.createQuery("select e FROM Utente e ORDER BY e.cognome", Utente.class)
                .getResultList();
    }

    /**
     * Insert o Update Utente su DB
     *
     * @param utente
     * @return
     */
    public Utente save(Utente utente) {
        return em.merge(utente);
    }
    
    /**
     * Restituisce l'Utente con id
     *
     * @param id
     * @return
     */
    public Utente find(int id) {
        return em.find(Utente.class, id);
    }
    
    /**
     * Rimuove da DB il Tag tramite id
     *
     * @param id
     */
    public void remove(int id) {
        Utente toremove = em.find(Utente.class, id);
        em.remove(toremove);
    }
}
