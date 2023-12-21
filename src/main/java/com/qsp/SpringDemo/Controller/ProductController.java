package com.qsp.SpringDemo.Controller;

import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.SpringDemo.DTO.Product;
import com.qsp.SpringDemo.ExceptionHandling.ProductIDNotFound;
import com.qsp.SpringDemo.Repository.ProductRepository;

@RestController
@RequestMapping("/product") // to reach controller class
public class ProductController {

	@Autowired
	ProductRepository repository;

	@PostMapping("/save") // to save the data
	public Product saveProduct(@RequestBody Product product) {

		Product save = repository.save(product);
		return save;
	}

	@GetMapping("/getAll")
	public List<Product> getProduct() {
		List<Product> findAll = repository.findAll();
		return findAll;
	}

	@GetMapping("/getOne/{id}")
	public Product getOneProduct(@PathVariable int id) throws ProductIDNotFound {
		Optional<Product> option = repository.findById(id);
		if (option == null) {
			throw new ProductIDNotFound();
		}

		return option.get();
	}

	@PutMapping("/update/{id}")
	public Product productUpdate(@RequestBody Product product, @PathVariable int id) throws ProductIDNotFound {
		Product p = repository.findById(id).orElse(null);
		if (p == null) {
			throw new ProductIDNotFound();
		} else {
			p.setProductId(product.getProductId());
			p.setProductName(product.getProductName());
			p.setProductPrice(product.getProductPrice());
			p.setProductType(product.getProductType());
		}
		return repository.save(p);
	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) throws ProductIDNotFound {
		Product product = repository.findById(id).orElse(null);
		if (product == null) {
			throw new ProductIDNotFound();
		}

		repository.delete(product);
		return "Deleted";

	}
	
	
	
}
