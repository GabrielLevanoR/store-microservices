package com.micro.store.shopping.Client;

import com.micro.store.shopping.Config.FeignClientConfig;
import com.micro.store.shopping.Model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(
        name = "msvc-product",
        url = "${external.product}",
        configuration = FeignClientConfig.class
)
public interface ProductClient {

    @GetMapping(value = "/{id}")
    @CircuitBreaker(name = "productCB", fallbackMethod = "fallBackGetProduct")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id);

    @GetMapping(value = "/{id}/stock")
    @CircuitBreaker(name = "productCB", fallbackMethod = "fallBackUpdateStock")
    public ResponseEntity<Product> updateStock(
            @PathVariable Long id,
            @RequestParam(name = "quantity") Double quantity
    );

    default ResponseEntity<Product> fallBackGetProduct(Exception e){
        Product product = Product.builder()
                .name("none")
                .description("none")
                .stock(0.0)
                .price(0.0)
                .build();
        return ResponseEntity.ok(product);
    }
    default  ResponseEntity<Product> fallBackUpdateStock(Exception e){
        Product product = Product.builder()
                .name("none")
                .description("none")
                .stock(0.0)
                .price(0.0)
                .build();
        return ResponseEntity.ok(product);
    }
}
