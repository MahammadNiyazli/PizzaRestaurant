/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "indent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indent.findAll", query = "SELECT i FROM Indent i"),
    @NamedQuery(name = "Indent.findById", query = "SELECT i FROM Indent i WHERE i.id = :id"),
    @NamedQuery(name = "Indent.findByPrice", query = "SELECT i FROM Indent i WHERE i.price = :price"),
    @NamedQuery(name = "Indent.findByDate", query = "SELECT i FROM Indent i WHERE i.date = :date"),
    @NamedQuery(name = "Indent.findByPayment", query = "SELECT i FROM Indent i WHERE i.payment = :payment"),
    @NamedQuery(name = "Indent.findByDelivered", query = "SELECT i FROM Indent i WHERE i.delivered = :delivered")})
public class Indent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 255)
    @Column(name = "payment")
    private String payment;
    @Size(max = 255)
    @Column(name = "delivered")
    private String delivered;
    @OneToMany(mappedBy = "indentId", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Canceled> canceledList;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Product productId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User userId;
    @OneToMany(mappedBy = "indentId", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<UserBasket> userBasketList;

    public Indent() {
    }

    public Indent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDelivered() {
        return delivered;
    }

    public void setDelivered(String delivered) {
        this.delivered = delivered;
    }

    @XmlTransient
    public List<Canceled> getCanceledList() {
        return canceledList;
    }

    public void setCanceledList(List<Canceled> canceledList) {
        this.canceledList = canceledList;
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

    @XmlTransient
    public List<UserBasket> getUserBasketList() {
        return userBasketList;
    }

    public void setUserBasketList(List<UserBasket> userBasketList) {
        this.userBasketList = userBasketList;
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
        if (!(object instanceof Indent)) {
            return false;
        }
        Indent other = (Indent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.Indent[ id=" + id + " ]";
    }
    
}
