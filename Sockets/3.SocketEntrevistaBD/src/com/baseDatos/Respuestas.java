/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baseDatos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonatan
 */
@Entity
@Table(name = "respuestas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuestas.findAll", query = "SELECT r FROM Respuestas r"),
    @NamedQuery(name = "Respuestas.findByMensage1", query = "SELECT r FROM Respuestas r WHERE r.mensage1 = :mensage1"),
    @NamedQuery(name = "Respuestas.findByMensage2", query = "SELECT r FROM Respuestas r WHERE r.mensage2 = :mensage2"),
    @NamedQuery(name = "respuesta", query="SELECT r FROM Respuestas r WHERE r.mensage1 =?1")})
    
public class Respuestas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mensage1")
    private String mensage1;
    @Basic(optional = false)
    @Column(name = "mensage2")
    private String mensage2;

    public Respuestas() {
    }

    public Respuestas(String mensage1) {
        this.mensage1 = mensage1;
    }

    public Respuestas(String mensage1, String mensage2) {
        this.mensage1 = mensage1;
        this.mensage2 = mensage2;
    }

    public String getMensage1() {
        return mensage1;
    }

    public void setMensage1(String mensage1) {
        this.mensage1 = mensage1;
    }

    public String getMensage2() {
        return mensage2;
    }

    public void setMensage2(String mensage2) {
        this.mensage2 = mensage2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mensage1 != null ? mensage1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuestas)) {
            return false;
        }
        Respuestas other = (Respuestas) object;
        if ((this.mensage1 == null && other.mensage1 != null) || (this.mensage1 != null && !this.mensage1.equals(other.mensage1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.baseDatos.Respuestas[ mensage1=" + mensage1 + " ]";
    }
    
}
