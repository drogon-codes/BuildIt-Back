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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "build")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Build.findAll", query = "SELECT b FROM Build b"),
    @NamedQuery(name = "Build.findByBuildId", query = "SELECT b FROM Build b WHERE b.buildId = :buildId"),
    @NamedQuery(name = "Build.findByFactorId", query = "SELECT b FROM Build b WHERE b.factorId = :factorId"),
    @NamedQuery(name = "Build.findByProductId", query = "SELECT b FROM Build b WHERE b.productId = :productId"),
    @NamedQuery(name = "Build.findByUserId", query = "SELECT b FROM Build b WHERE b.userId = :userId")})
public class Build implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "build_id")
    private Integer buildId;
    @Basic(optional = false)
    @Column(name = "factor_id")
    private int factorId;
    @Basic(optional = false)
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;

    public Build() {
    }

    public Build(Integer buildId) {
        this.buildId = buildId;
    }

    public Build(Integer buildId, int factorId, int productId, int userId) {
        this.buildId = buildId;
        this.factorId = factorId;
        this.productId = productId;
        this.userId = userId;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public int getFactorId() {
        return factorId;
    }

    public void setFactorId(int factorId) {
        this.factorId = factorId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
        return "model.Build[ buildId=" + buildId + " ]";
    }
    
}
