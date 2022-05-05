
-- Table: Properties
CREATE TABLE Properties (
    property_id int NOT NULL,
    name varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    province varchar(255) NOT NULL,
    postal varchar(255) NOT NULL,
    access_247 bool NULL,
    utilities_included bool NULL,
    availability date NULL,
    cost int NULL,
    CONSTRAINT Properties_pk PRIMARY KEY (property_id)
);
