package com.qsp.SpringDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qsp.SpringDemo.DTO.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	String findByEmployeeEmail(String email); 
}
