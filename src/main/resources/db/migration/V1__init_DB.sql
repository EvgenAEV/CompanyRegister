-- create table company_register
-- (
--     companyId int auto increment primary key ,
--     companyName varchar (200) not null,
--     countryName varchar (200) not null
-- );
 create table company_register
 (
     company_id int8 generated by default as identity,
      company_name varchar(200) not null ,
      country varchar(200) not null ,
      primary key (company_id)
 );
