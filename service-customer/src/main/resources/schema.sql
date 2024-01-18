DROP TABLE IF EXISTS tbl_customers;

CREATE TABLE tbl_customers (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    number_id VARCHAR(8) NOT NULL,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    photo_url VARCHAR(250),
    email VARCHAR(250) NOT NULL,
    state VARCHAR(250) NOT NULL,
    region_id BIGINT
);

DROP TABLE IF EXISTS tbl_regions;

CREATE TABLE tbl_regions (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);