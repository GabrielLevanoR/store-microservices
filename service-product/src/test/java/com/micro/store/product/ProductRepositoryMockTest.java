package com.micro.store.product;

import com.micro.store.product.Entity.Category;
import com.micro.store.product.Entity.Product;
import com.micro.store.product.Repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {
    @Autowired
    private ProductRepository productRepository;
    @Test
    public void whenFindByCategory_thenReturnListProduct(){
        Product product = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1499.50"))
                .status("Created")
                .createAt(new Date()).build();
        productRepository.save(product);

        List<Product> founds = productRepository.findByCategory((product.getCategory()));
        Assertions.assertThat(founds.size()).isEqualTo(3);

    }
}
