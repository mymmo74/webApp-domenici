/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baruzzi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_giocatori")
public class Giocatore implements Serializable{
    // @Id per indicare la proprietà che è la chiave primaria sul db
    @Id
    
    @Column(name = "id_giocatore")
    private int id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "ruolo")
    private String ruolo;
    
    public Giocatore() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Giocatore other = (Giocatore) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Giocatore{" + "id=" + id + ", nome=" + nome + ", numero=" + numero + ", ruolo=" + ruolo + '}';
    }
    
}
