package com.ankit.repository;

import java.util.List;
//
//public interface ProductRepository extends JpaRepository<Product,Integer> {
//    List<Product> findByCategory(String category);
//}

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankit.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findByCategory(String category);
}
