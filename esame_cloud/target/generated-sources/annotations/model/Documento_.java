package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Utente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-11T11:56:51")
@StaticMetamodel(Documento.class)
public class Documento_ { 

    public static volatile SingularAttribute<Documento, Utente> utente;
    public static volatile SingularAttribute<Documento, String> path;
    public static volatile SingularAttribute<Documento, String> titolo;
    public static volatile SingularAttribute<Documento, Long> idDocumento;
    public static volatile ListAttribute<Documento, Utente> condivisioni;

}