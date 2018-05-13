
package ru.feel.queststore.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.feel.queststore.dao.ProductDao;
import ru.feel.queststore.model.Product;

/**
 *
 * @author Anton
 */
@Service
public class ProductServImpl implements ProductService{
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	@Transactional
	public void addProduct(Product product) {
		this.productDao.addProduct(product);
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		this.productDao.updateProduct(product);
	}

	@Override
	@Transactional
	public void removeProduct(int id) {
		this.productDao.removeProduct(id);
	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		return this.productDao.getProductById(id);
	}

	@Override
	@Transactional
	public List<Product> listProduct() {
		return this.productDao.listProducts();
	}
}
