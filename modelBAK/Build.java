/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.buidit.BuildItBack.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author c computer
 */
@Entity
@Table(name = "build")
@NamedQueries({
    @NamedQuery(name = "Build.findAll", query = "SELECT b FROM Build b"),
    @NamedQuery(name = "Build.findByBuildId", query = "SELECT b FROM Build b WHERE b.buildId = :buildId")})
public class Build implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "build_id")
    private Integer buildId;
    @JoinColumn(name = "factor_id", referencedColumnName = "factor_id")
    @ManyToOne(optional = false)
    private Factor factorId;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Build() {
    }

    public Build(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Factor getFactorId() {
        return factorId;
    }

    public void setFactorId(Factor factorId) {
        this.factorId = factorId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buildId != null ? buildId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Build)) {
            return false;
        }
        Build other = (Build) object;
        if ((this.buildId == null && other.buildId != null) || (this.buildId != null && !this.buildId.equals(other.buildId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Build[ buildId=" + buildId + " ]";
    }
    
}
