package com.mmit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mmit.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	//custom query
	@Query("SELECT p FROM Product p WHERE p.brand=:bname")
	List<Product> findByBrandName(@Param("bname") String bname);
	
	//naming rule method
	List<Product> findByPriceLessThan(int price);

}
