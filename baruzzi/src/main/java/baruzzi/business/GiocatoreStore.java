/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baruzzi.business;

import baruzzi.entity.Giocatore;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class GiocatoreStore {
    
    @PersistenceContext()
    EntityManager em;

    /**
     * *
     * Restituisce tutti i tag
     *
     * @return
     */
    public List<Giocatore> all() {
        // Dammi tutti 
        return em.createQuery("select e FROM Giocatore e ORDER BY e.nome ", Giocatore.class)
                .getResultList();
    }

    // per salvare nuovo record su DB
    public Giocatore create(Giocatore gioc) {
        return em.merge(gioc);
    }

    /**
     * *
     * Insert o Update su DB
     *
     * @param gioc
     * @return
     */
    public Giocatore save(Giocatore gioc) {
        return em.merge(gioc);
    }

    /**
     * Ritorna il tag con ID passato
     *
     * @param id
     * @return
     */
    public Giocatore find(int id) {
        return em.find(Giocatore.class, id);
    }

    /**
     * Cancella il record passando l'ID
     *
     * @param id
     */
    public void remove(int id) {
        // prima si cerca per ID e poi si cancella
        Giocatore toremove = em.find(Giocatore.class, id);
        em.remove(toremove);
    }

   
}
