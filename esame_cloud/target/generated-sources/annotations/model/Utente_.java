package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-11T11:56:51")
@StaticMetamodel(Utente.class)
public class Utente_ { 

    public static volatile SingularAttribute<Utente, String> password;
    public static volatile SingularAttribute<Utente, Date> tokenEnd;
    public static volatile SingularAttribute<Utente, Long> id;
    public static volatile SingularAttribute<Utente, String> email;
    public static volatile SingularAttribute<Utente, String> token;

}