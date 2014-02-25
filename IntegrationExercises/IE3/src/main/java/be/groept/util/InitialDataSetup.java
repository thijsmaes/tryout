package be.groept.util;

import java.math.BigDecimal;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import be.groept.ie3.entities.Address;
import be.groept.ie3.entities.Customer;
import be.groept.ie3.entities.Eshop;
import be.groept.ie3.entities.Order;
import be.groept.ie3.entities.OrderDetail;
import be.groept.ie3.entities.Product;

public class InitialDataSetup {

	private TransactionTemplate transactionTemplate;
	@Autowired
	private SessionFactory sessionFactory;

	public InitialDataSetup(TransactionTemplate transactionTemplate,
			SessionFactory sessionFactory) {
		this.transactionTemplate = transactionTemplate;
		this.sessionFactory = sessionFactory;
	}

	public void initData() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {

				// Setup test data
				{
					Address address1 = new Address();
					address1.setCountry("belgium");
					address1.setStreet("koekoekstraat");
					address1.setHouseNumber(1);
					address1.setMunicipality("Melle");
					
					Eshop eshop = new Eshop();
					eshop.setName("tacoteo");
					eshop.setAddress(address1);
					sessionFactory.getCurrentSession().save(address1);
					sessionFactory.getCurrentSession().save(eshop);
					
					Customer a= new Customer();
					a.setFirstName("pol");
					a.setUserName("polleke");
					a.setPassWord("azerty");
					sessionFactory.getCurrentSession().save(a);
					Customer b = new Customer();
					b.setFirstName("lien");
					b.setUserName("lieneke");
					b.setPassWord("querty");
					sessionFactory.getCurrentSession().save(b);
					
					Product beer = new Product();
					beer.setName("Stella");
					beer.setNumbersInStock(300);
					beer.setPrice(new BigDecimal("15"));
					Product chips = new Product();
					chips.setName("Lays");
					chips.setNumbersInStock(23);
					chips.setPrice(new BigDecimal("1.5"));
					Product nachos = new Product();
					nachos.setName("doritos");
					nachos.setPrice(new BigDecimal("2.25"));
					Product dvd = new Product();
					dvd.setName("dvd");
					dvd.setPrice(new BigDecimal("8.49"));
					dvd.setNumbersInStock(74);
					Product cd = new Product();
					cd.setPrice(new BigDecimal("14.99"));
					cd.setNumbersInStock(3);
					cd.setName("Pink Floyd");
					sessionFactory.getCurrentSession().save(beer);
					sessionFactory.getCurrentSession().save(chips);
					sessionFactory.getCurrentSession().save(nachos);
					sessionFactory.getCurrentSession().save(dvd);
					sessionFactory.getCurrentSession().save(cd);
					
					Order order1 = new Order();
					order1.setCustomer(a);
					order1.setShop(eshop);
					Order order2 = new Order();
					order2.setCustomer(b);
					order2.setShop(eshop);
					
					OrderDetail detail1 = new OrderDetail();
					detail1.setProduct(cd);
					detail1.setOrder(order1);
					OrderDetail detail2 = new OrderDetail();
					detail2.setOrder(order1);
					detail2.setProduct(dvd);
					
					sessionFactory.getCurrentSession().save(order1);
					sessionFactory.getCurrentSession().save(order2);
					sessionFactory.getCurrentSession().save(detail1);
					sessionFactory.getCurrentSession().save(detail2);
					
				}
			}
		});
	}

	public void tearDown() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
			}
		});
	}
}
