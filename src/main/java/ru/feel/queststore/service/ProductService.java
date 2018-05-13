
package ru.feel.queststore.service;

import java.util.List;
import ru.feel.queststore.model.Product;

/**
 *
 * @author Anton
 */
public interface ProductService {
	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void removeProduct(int id);
	
	public Product getProductById(int id);
	
	public List<Product> listProduct();
}
