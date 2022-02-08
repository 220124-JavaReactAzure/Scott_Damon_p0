drop table customer;
drop table accountDetails;

create table customer(
	customer_id int,
	first_name varchar(40),
	last_name varchar(40),
	email varchar(40),
	username varchar(40),
	passvord varchar(40),
	primary key (customer_id) 
);

create table accountDetails(
	account_type varchar(40),
	customer_account_id int,
	checking_balance double precision,
	savings_balance double precision,
	account_id int primary key,
	foreign key (customer_account_id) references customer(customer_id)
	);