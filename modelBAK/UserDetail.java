/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.buidit.BuildItBack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author c computer
 */
@Entity
@Table(name = "user_detail")
@NamedQueries({
    @NamedQuery(name = "UserDetail.findAll", query = "SELECT u FROM UserDetail u"),
    @NamedQuery(name = "UserDetail.findByUserDetailId", query = "SELECT u FROM UserDetail u WHERE u.userDetailId = :userDetailId"),
    @NamedQuery(name = "UserDetail.findByCity", query = "SELECT u FROM UserDetail u WHERE u.city = :city"),
    @NamedQuery(name = "UserDetail.findByCompanyName", query = "SELECT u FROM UserDetail u WHERE u.companyName = :companyName"),
    @NamedQuery(name = "UserDetail.findByFirstName", query = "SELECT u FROM UserDetail u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserDetail.findByLastName", query = "SELECT u FROM UserDetail u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserDetail.findByPincode", query = "SELECT u FROM UserDetail u WHERE u.pincode = :pincode"),
    @NamedQuery(name = "UserDetail.findByUserId", query = "SELECT u FROM UserDetail u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserDetail.findByState", query = "SELECT u FROM UserDetail u WHERE u.state = :state")})
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_detail_id")
    private Integer userDetailId;
    @Lob
    @Size(max = 65535)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "city")
    private String city;
    @Size(max = 255)
    @Column(name = "company_name")
    private String companyName;
    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "pincode")
    private Integer pincode;
    @Size(max = 255)
    @Column(name = "state")
    private String state;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    @ManyToOne(optional = false)
    private User userId;

    public UserDetail() {
    }

    public UserDetail(Integer userDetailId) {
        this.userDetailId = userDetailId;
    }

    public Integer getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(Integer userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        hash += (userDetailId != null ? userDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDetail)) {
            return false;
        }
        UserDetail other = (UserDetail) object;
        if ((this.userDetailId == null && other.userDetailId != null) || (this.userDetailId != null && !this.userDetailId.equals(other.userDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserDetail[ userDetailId=" + userDetailId + " ]";
    }
    
}
