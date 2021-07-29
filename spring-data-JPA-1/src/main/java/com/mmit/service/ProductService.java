package com.mmit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmit.entity.Product;
import com.mmit.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;

	public List<Product> findAll() {
		return repo.findAll();
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	public void saveProduct(Product product) {
		repo.save(product);
		
	}

	public void deleteById(int id) {
		repo.deleteById(id);
		
	}

	public List<Product> findByBrand(String brandName) {
		List<Product> list=repo.findByBrandName(brandName);
		return list;
	}

	public List<Product> findByPrice(int price) {
		
		return repo.findByPriceLessThan(price);
	}
	
	

}
