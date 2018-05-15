/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feel.queststore.model;



import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author Anton
 */
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "STORE_ID")
    private int store_id;
    @Column(name = "PRODUCT_ID")
    private int product_id;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "VALUE")
    private int value;
	@Temporal(TemporalType.DATE)
    @Column(name = "DATEANDTIME", nullable = true, insertable = false, updatable = false)
    private Date datetime;
//	@ManyToOne
//	@JoinColumn(name = "store_id")
//	private Store store;
//	@ManyToOne
//	@JoinColumn(name = "product_id")
//	private Product product;
//
//	public Store getStore() {
//		return store;
//	}
//
//	public void setStore(Store store) {
//		this.store = store;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

	@Override
	public String toString() {
		return "Transaction{" + "id=" + id + ", "
				+ "store_id=" + store_id + ", "
				+ "product_id=" + product_id + ", "
				+ "quantity=" + quantity + ", "
				+ "value=" + value + ", "
				+ "datetime=" + datetime + '}';
	}
	
}
