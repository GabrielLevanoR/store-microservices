package com.micro.store.shopping.Client;

import com.micro.store.shopping.Config.FeignClientConfig;
import com.micro.store.shopping.Model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
        name = "msvc-customer",
        url = "${external.customer}",
        configuration = FeignClientConfig.class
)
public interface CustomerClient {
    @GetMapping(value = "/{id}")
    @CircuitBreaker(name= "customerCB", fallbackMethod = "fallBackGetCustomer")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);

    default ResponseEntity<Customer> fallBackGetCustomer(Exception e){
        Customer customer = Customer.builder()
                .firstName("none")
                .lastName("none")
                .email("none")
                .photoUrl("none")
                .build();
        return ResponseEntity.ok(customer);
    }
}
