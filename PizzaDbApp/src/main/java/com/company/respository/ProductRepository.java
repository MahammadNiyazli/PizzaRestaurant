package com.company.respository;

import com.company.customRepository.ProductRepositoryCustom;
import com.company.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>, ProductRepositoryCustom {
}
