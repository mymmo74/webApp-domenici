/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.business;

import it.ciacformazione.nostalciac.entity.Anagrafica;
import it.ciacformazione.nostalciac.entity.Corso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class AnagraficaStore {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Anagrafica> findAll(){
        return em.createQuery("select e from Anagrafica e order by e.cognome", Anagrafica.class)
                .getResultList();
    }
    
    public Anagrafica find(Integer id){
        return em.find(Anagrafica.class, id);
    }
    
    public Anagrafica save(Anagrafica a){
        return em.merge(a);
    }
    
    public void remove(Integer id){
        em.remove(find(id));
    }
    
    public List<Corso> corsi(Integer id){
        return em.createQuery("select e.corsi from Anagrafica e where e.id= :id", Corso.class)
                .setParameter("id", id)
                .getResultList();
    }
}
