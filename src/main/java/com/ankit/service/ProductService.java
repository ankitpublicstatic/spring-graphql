package com.ankit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankit.entity.Product;
import com.ankit.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public List<Product> getProductsByCategory(String category) {
		return repository.findByCategory(category);
	}

	// sales team : update the stock of a product in (IS)
	public Product updateStock(String id, int stock) {

		Product existingProduct = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("product not found with id " + id));

		existingProduct.setStock(stock);
		return repository.save(existingProduct);
	}

	// warehouse : receive new shipment
	public Product receiveNewShipment(String id, int quantity) {

		Product existingProduct = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("product not found with id " + id));

		existingProduct.setStock(existingProduct.getStock() + quantity);
		return repository.save(existingProduct);
	}
}
