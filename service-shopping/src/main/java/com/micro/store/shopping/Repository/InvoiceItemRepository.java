package com.micro.store.shopping.Repository;

import com.micro.store.shopping.Entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long>{
}
