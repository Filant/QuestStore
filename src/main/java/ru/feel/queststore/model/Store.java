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
@Table(name = "STORE")
public class Store {
    @Id
    @Column(name = "ID", insertable = false, nullable = false, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ADDRESS")
    private String address;
	@Column(name = "NAME")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	@Override
	public String toString() {
		return "Store{" + "id=" + id + ", address=" + address + ", name=" + name + '}';
	}

	
}
