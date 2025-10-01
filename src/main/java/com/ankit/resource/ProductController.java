package com.ankit.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ankit.entity.Product;
import com.ankit.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@QueryMapping
	public List<Product> getProducts() {
		return service.getProducts();
	}

	@QueryMapping
	public List<Product> getProductsByCategory(@Argument String category) {
		return service.getProductsByCategory(category);
	}

	@MutationMapping
	public Product updateStock(@Argument String id, @Argument int stock) {
		return service.updateStock(id, stock);

	}

	@MutationMapping
//	@SubscriptionMapping
	public Product receiveNewShipment(@Argument String id, @Argument int quantity) {
		return service.receiveNewShipment(id, quantity);

	}
}
