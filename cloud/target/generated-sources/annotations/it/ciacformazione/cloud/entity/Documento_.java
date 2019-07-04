package it.ciacformazione.cloud.entity;

import it.ciacformazione.cloud.entity.Utente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-04T13:48:26")
@StaticMetamodel(Documento.class)
public class Documento_ { 

    public static volatile SingularAttribute<Documento, Utente> utente;
    public static volatile SingularAttribute<Documento, String> descrizione;
    public static volatile SingularAttribute<Documento, String> nome_file;
    public static volatile SingularAttribute<Documento, Integer> id;

}