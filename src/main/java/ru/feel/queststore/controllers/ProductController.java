/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feel.queststore.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.feel.queststore.model.Product;
import ru.feel.queststore.service.ProductService;

/**
 *
 * @author Anton
 */
@Controller("/product")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired(required = true)
	@Qualifier(value = "productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String addProduct (@ModelAttribute("product") Product product){
		if(product.getId() == 0){
			this.productService.addProduct(product);
		}else{
			this.productService.updateProduct(product);
		}
		return "redirect:/products";
	}
	
	@RequestMapping("/removeProduct/{id}")
	public String removeProdcut(@PathVariable("id") int id){
		this.productService.removeProduct(id);
		return "redirect:/products";
	}
	
	@RequestMapping("editProduct/{id}")
	public String editProduct(@PathVariable("id") int id, Model model){
		model.addAttribute("product", this.productService.getProductById(id));
		model.addAttribute("listProduct", this.productService.listProduct());
		return "products";
	}
	
	@RequestMapping("productdata/{id}")
	public String productData(@PathVariable("id") int id, Model model){
		model.addAttribute("product", this.productService.getProductById(id));
		
		return "productdata";
	}
	
	@RequestMapping(value = "products", method = RequestMethod.GET)
	public String listProducts(Model model){
		model.addAttribute("product", new Product());
		model.addAttribute("listProduct", this.productService.listProduct());
		
		return "products";
	}
}
