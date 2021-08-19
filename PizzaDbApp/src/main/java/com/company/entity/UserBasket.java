/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "user_basket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserBasket.findAll", query = "SELECT u FROM UserBasket u"),
    @NamedQuery(name = "UserBasket.findById", query = "SELECT u FROM UserBasket u WHERE u.id = :id")})
public class UserBasket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "indent_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Indent indentId;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Product productId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User userId;

    public UserBasket() {
    }

    public UserBasket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Indent getIndentId() {
        return indentId;
    }

    public void setIndentId(Indent indentId) {
        this.indentId = indentId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBasket)) {
            return false;
        }
        UserBasket other = (UserBasket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.UserBasket[ id=" + id + " ]";
    }
    
}
