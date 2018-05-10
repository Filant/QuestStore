/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feel.queststore.dao;

import java.util.List;
import ru.feel.queststore.model.Product;

/**
 *
 * @author Anton
 */
public interface ProductDao {
    public void addProduct(Product prodcut);
    public void updatePRoduct(Product prodcut);
    public void removeProduct(int id);
    public Product getProductById(int id);
    public List<Product> listProducts();
    
}
