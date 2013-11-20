package be.groept.hibernate.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import be.groept.hibernate.entities.filters.Category;
import be.groept.hibernate.entities.filters.Item;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class FilterTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private SessionFactory sessionFactory;

	public void testFilter() {

		Category category = new Category();

		Item itemOne = new Item();
		itemOne.setItemCode(1000L);
		Item itemTwo = new Item();
		itemTwo.setItemCode(2000L);
		Item itemThree = new Item();
		itemThree.setItemCode(2000L);

		List<Item> items = new ArrayList<Item>();

		items.add(itemOne);
		items.add(itemTwo);
		items.add(itemThree);

		category.setItems(items);
		sessionFactory.getCurrentSession().save(category);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();

		List<Item> fetchedItems = sessionFactory.getCurrentSession()
				.createQuery("from Item").list();
		Category fetchedCategory = (Category) sessionFactory
				.getCurrentSession().get(Category.class, category.getId());

		// This will print two times '3' since all items are returned, by query
		// and model navigation
		System.err.println(fetchedItems.size());
		System.err.println(fetchedCategory.getItems().size());

		// Enable filter
		sessionFactory.getCurrentSession().enableFilter("itemCodeFilter")
				.setParameter("itemcode", new Long(1000));
		sessionFactory.getCurrentSession().clear();

		fetchedItems = sessionFactory.getCurrentSession()
				.createQuery("from Item").list();
		fetchedCategory = (Category) sessionFactory.getCurrentSession().get(
				Category.class, category.getId());

		// This will print two times '2' since only items of which the item code
		// is higher then 1000
		// are returned, by query and model navigation
		System.err.println(fetchedItems.size());
		System.err.println(fetchedCategory.getItems().size());
	}
}
