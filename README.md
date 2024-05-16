For MySQL Setup
CREATE A SCHEMA: spring_microservice

CREATE A TABLE:

CREATE TABLE spm_customer (
cmr_id INT NOT NULL AUTO_INCREMENT,
cmr_name char(50),
cmr_mobile char(20),
cmr_email char(50),
cmr_address1 char(100),
cmr_address2 char(100),
cmr_type char(1),
PRIMARY KEY (cmr_id)
);

