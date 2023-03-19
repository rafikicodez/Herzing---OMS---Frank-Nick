package com.springboot.OMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.OMS.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
