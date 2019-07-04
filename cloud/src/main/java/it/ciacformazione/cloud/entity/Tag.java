/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.cloud.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_tags")
public class Tag implements Serializable {
    @Id
    @Column(name = "id_tag")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nome_tag")
    private String nome_tag;
    
    @ManyToMany
    @JoinTable(
            name = "t_documenti",
            joinColumns = @JoinColumn(name = "id_documento",
                    referencedColumnName = "id_documento"),
    )
    private 
}
