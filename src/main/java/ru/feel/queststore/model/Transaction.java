/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feel.queststore.model;

import javax.persistence.*;
/**
 *
 * @author Anton
 */
@Entity
@Table(name = "transactions")
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
    @Column(name = "DATEANDTIME")
    private String datetime;

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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
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
