DROP TABLE IF EXISTS tbl_products;

CREATE TABLE tbl_invoce_items (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    invoice_id BIGINT,
    product_id BIGINT,
    quantity INTEGER NOT NULL,
    price DOUBLE NOT NULL
);

DROP TABLE IF EXISTS tbl_categories;

CREATE TABLE tlb_invoices (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    number_invoice VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL,
    customer_id BIGINT,
    create_at TIMESTAMP NOT NULL,
    state VARCHAR(250) NOT NULL,
);