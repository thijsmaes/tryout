package be.groept.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class InitialDataSetup {

	private TransactionTemplate transactionTemplate;
	private JdbcTemplate jdbcTemplate;

	public InitialDataSetup(TransactionTemplate transactionTemplate,
			JdbcTemplate jdbcTemplate) {
		this.transactionTemplate = transactionTemplate;
		this.jdbcTemplate = jdbcTemplate;
	}

	public void initData() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// Create tables
				{
					jdbcTemplate
							.execute("create table orders (id bigint auto_increment, orderId varchar2(255) , customerId varchar2(255), delivered boolean, deliveryDays int, totalOrderPrice decimal(10,2))");
					jdbcTemplate
							.execute("create table products (id bigint auto_increment, orderId bigint, productName varchar2(255), productDescription varchar2(255), productPrice decimal(10,2))");
				}

				// Setup test data
				{
					jdbcTemplate.execute("insert into orders (orderId, customerId, delivered, deliveryDays, totalOrderPrice) values ('order1', 'cust1', false, 10, 3646.02)");
					jdbcTemplate.execute("insert into orders (orderId, customerId, delivered, deliveryDays, totalOrderPrice) values ('order2', 'cust2', false, 11, 501.09)");
					jdbcTemplate.execute("insert into orders (orderId, customerId, delivered, deliveryDays, totalOrderPrice) values ('order3', 'cust3', false, 12, 599.99)");
					
					jdbcTemplate.execute("insert into products (orderId, productName, productDescription, productPrice) values (1, 'Television', 'Television description', 1000.13)");
					jdbcTemplate.execute("insert into products (orderId, productName, productDescription, productPrice) values (1, 'Hifi', 'Hifi description', 544.90)");
					jdbcTemplate.execute("insert into products (orderId, productName, productDescription, productPrice) values (1, 'Laptop', 'Laptop description', 2100.99)");

					jdbcTemplate.execute("insert into products (orderId, productName, productDescription, productPrice) values (2, 'Tablet', 'Tablet description', 499.99)");
					jdbcTemplate.execute("insert into products (orderId, productName, productDescription, productPrice) values (2, 'Typewriter', 'Typewriter description', 1.10)");

					jdbcTemplate.execute("insert into products (orderId, productName, productDescription, productPrice) values (3, 'S3', 'Samsung galaxy s3', 599.99)");
				}
			}
		});
	}
}
