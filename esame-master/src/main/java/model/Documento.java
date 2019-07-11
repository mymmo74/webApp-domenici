
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "documenti")
@XmlRootElement 
public class Documento implements Serializable{

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento")
    private Long idDocumento;
    
    @Size(max = 255)
    @Column(name = "titolo")
    private String titolo;
    
    @Size(max = 255)
    @Column(name = "path")
    private String path;
    
    @ManyToOne
    private Utente utente;
     
    @ManyToMany
    private List<Utente> condivisioni;
    
   

    public Documento() {
    }

    public Documento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Utente> getCondivisioni() {
        return condivisioni;
    }

    public void setCondivisioni(List<Utente> condivisioni) {
        this.condivisioni = condivisioni;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cloud.Documenti[ idDocumento=" + idDocumento + " ]";
    }
    
}