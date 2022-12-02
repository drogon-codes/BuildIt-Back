/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.buidit.BuildItBack.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author c computer
 */
@Entity
@Table(name = "factor")
@NamedQueries({
    @NamedQuery(name = "Factor.findAll", query = "SELECT f FROM Factor f"),
    @NamedQuery(name = "Factor.findByFactorId", query = "SELECT f FROM Factor f WHERE f.factorId = :factorId"),
    @NamedQuery(name = "Factor.findByFactorName", query = "SELECT f FROM Factor f WHERE f.factorName = :factorName"),
    @NamedQuery(name = "Factor.findByIsActive", query = "SELECT f FROM Factor f WHERE f.isActive = :isActive")})
public class Factor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "factor_id")
    private Integer factorId;
    @Size(max = 255)
    @Column(name = "factor_name")
    private String factorName;
    @Size(max = 255)
    @Column(name = "is_active")
    private String isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factorId")
    private Collection<Build> buildCollection;

    public Factor() {
    }

    public Factor(Integer factorId) {
        this.factorId = factorId;
    }

    public Integer getFactorId() {
        return factorId;
    }

    public void setFactorId(Integer factorId) {
        this.factorId = factorId;
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Collection<Build> getBuildCollection() {
        return buildCollection;
    }

    public void setBuildCollection(Collection<Build> buildCollection) {
        this.buildCollection = buildCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factorId != null ? factorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factor)) {
            return false;
        }
        Factor other = (Factor) object;
        if ((this.factorId == null && other.factorId != null) || (this.factorId != null && !this.factorId.equals(other.factorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Factor[ factorId=" + factorId + " ]";
    }
    
}
