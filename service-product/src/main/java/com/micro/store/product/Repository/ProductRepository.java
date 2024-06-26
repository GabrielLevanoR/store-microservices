package com.micro.store.product.Repository;

import com.micro.store.product.Entity.Category;
import com.micro.store.product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategory(Category category);
}
