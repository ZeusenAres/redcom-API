/*package com.redcom.redcom.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderNumber;

    @OneToMany(targetEntity = Users.class, mappedBy = "orders", fetch = FetchType.EAGER)
    private Users users;

    private List<Products> products;

    private int totalPrice;

    private int discountPercentage;

    public Orders()
    {

    }

    public int getOrderNumber()
    {
        return orderNumber;
    }

    public int setOrderNumber(int orderNumber)
    {
        return this.orderNumber = orderNumber;
    }

    public Users getCustomerId()
    {
        return users;
    }

    public Users setCustomerId(Users user)
    {
        return this.users = user;
    }

    public List<Products> getProductIds()
    {
        return products;
    }

    /*public List<Integer> addToProductIds(Integer productId)
    {
        productIds.add(productId);
        return productIds;
    }

    public List<Integer> removeFromProductIds(Integer productId)
    {
        productIds.r;
        return productIds;
    }

    public int getTotalPrice()
    {
        return totalPrice;
    }

    public int setTotalPrice(int totalPrice)
    {
        return this.totalPrice = totalPrice;
    }

    public int getDiscountedPercentage()
    {
        return discountPercentage;
    }

    public int setDiscountedPercentage(int discountPercentage)
    {
        return this.discountPercentage = discountPercentage;
    }
}*/
