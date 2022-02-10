drop table customer;
drop table accountDetails;

create table customer(
	customer_id varchar(128) primary key,
	first_name varchar(40),
	last_name varchar(40),
	email varchar(40),
	username varchar(40),
	pass varchar(40)
);

create table accountDetails(
	account_id varchar (128) primary key,
	customer_account_id varchar(128),
	balance double precision,
	account_name varchar(40),
	foreign key (customer_account_id) references customer(customer_id)
	);
	
select * from customer;

delete from customer where username = 'user1';