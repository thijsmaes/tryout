package be.groept.ie3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.groept.ie3.entities.Eshop;

@Repository
public class ShopDaoImpl implements ShopDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Eshop> listAllShops() {
		return sessionFactory.getCurrentSession().createQuery("from Eshop").list();
	}
}
