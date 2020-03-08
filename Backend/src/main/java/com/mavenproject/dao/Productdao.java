package com.mavenproject.dao;
import java.util.List;

import com.mavenproject.model.Product;

public interface Productdao {
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public Product getProductByid(int p_id);
   public List<Product>listProduct();


}
