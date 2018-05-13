/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feel.queststore.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.feel.queststore.model.Product;

/**
 *
 * @author Anton
 */
@Repository
public class ProductImpl implements ProductDao{
	private static final Logger logger = LoggerFactory.getLogger(ProductImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
		logger.info("Product successfuly added: " + product);
	}

	@Override
	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
		logger.info("Product successfuly update: " + product);
	}

	@Override
	public void removeProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.load(Product.class, new Integer(id));
		
		if(product != null){
			session.delete(product);
			logger.info("Product successfuly deleted: " + product);
		}
	}

	@Override
	public Product getProductById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.load(Product.class, new Integer(id));
		logger.info("Product successfuly loaded: " + product);
		return product;
	}

	@Override
	public List<Product> listProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> listProduct = session.createQuery("from Product").list();
		
		for(Product product : listProduct){
			logger.info("Product info: " + product);
		}
		return listProduct;
	}
    
}
