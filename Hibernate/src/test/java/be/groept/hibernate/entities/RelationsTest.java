package be.groept.hibernate.entities;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import be.groept.hibernate.entities.relations.ChildMtm;
import be.groept.hibernate.entities.relations.ChildMtmDetail;
import be.groept.hibernate.entities.relations.ChildOtm;
import be.groept.hibernate.entities.relations.ChildOto;
import be.groept.hibernate.entities.relations.ParentMtm;
import be.groept.hibernate.entities.relations.ParentOtm;
import be.groept.hibernate.entities.relations.ParentOto;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class RelationsTest extends
		AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private SessionFactory sessionFactory;

	public void otm() {
		ParentOtm parent = new ParentOtm();
		parent.setParentName("parent");

		ChildOtm childOne = new ChildOtm();
		childOne.setChildName("child1");

		parent.getChilds().add(childOne);
		childOne.setParent(parent);

		Session session = sessionFactory.getCurrentSession();
		session.save(parent);
		session.flush();

		ParentOtm parent2 = new ParentOtm();
		parent2.setParentName("parent2");

		ChildOtm childOne2 = new ChildOtm();

		List<ParentOtm> list = session.createQuery("from ParentOtm p").list();
		for (ParentOtm p : list) {
			for (ChildOtm c : p.getChilds()) {
				System.err.println(c);
			}
		}
	}

	public void oto() {
		ParentOto parent = new ParentOto();
		ChildOto childOto = new ChildOto();
		parent.setChild(childOto);
		Session session = sessionFactory.getCurrentSession();
		session.save(parent);
		session.flush();
		session.flush();
	}

	public void mtm() {
		ParentMtm parent = new ParentMtm();
		ChildMtm childMtm = new ChildMtm();

		ChildMtmDetail childMtmDetail = new ChildMtmDetail();
		childMtmDetail.setAmount("10");
		childMtmDetail.setChildMtm(childMtm);
		parent.getChildDetails().add(childMtmDetail);

		Session session = sessionFactory.getCurrentSession();
		session.save(parent);
		session.flush();
		session.flush();
	}
}
