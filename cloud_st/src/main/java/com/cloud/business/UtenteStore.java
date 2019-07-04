/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.business;

import com.cloud.entity.Utente;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
public class UtenteStore {

    @PersistenceContext
    EntityManager em;

    public Utente findById(Integer id) {
        return em.find(Utente.class, id);
    }

    public Utente save(Utente c) {
        return em.merge(c);
    }

    public void remove(Integer id) {
        em.remove(findById(id));
    }

    public List<Utente> findAll() {
        return em.createQuery("select u from Utente u order by u.cognome", Utente.class)
                .getResultList();
    }

    public Optional<Utente> login(String mail, String pwd) {
        try {
            Utente p = em.createQuery("select e from Utente e where e.email :mail and e.pwd= :pwd", Utente.class)
                    .setParameter("mail", mail)
                    .setParameter("pwd", pwd)
                    .getSingleResult();
            return Optional.of(p);
        } catch (NoResultException | NonUniqueResultException ex) {
            return Optional.empty();
        }
    }
}
