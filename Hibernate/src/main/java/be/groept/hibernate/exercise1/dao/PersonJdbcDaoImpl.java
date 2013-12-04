package be.groept.hibernate.exercise1.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Person;

@Profile("jdbc")
@Transactional
@Repository
public class PersonJdbcDaoImpl extends JdbcTemplate implements PersonDao {

	@Autowired
	public PersonJdbcDaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	public List<Person> findAll() {
		return query("select * from person", new Object[] {}, new RowMapper<Person>() {

			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setName(rs.getString("name"));
				return person;
			}
		});
	}

	public List<Person> findByName(String name) {
		
		List people = query("select * from person where name= "+name, new Object[] {}, new RowMapper<Person>() {

			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setName(rs.getString("name"));
				return person;
			}
		});
		return people;
	}

	public void removePerson(Person person) {
		super.update("delete from person where id = " + person.getId());
		// TODO implement me
		// hint: super.update(".....
	}

	public void savePerson(Person person) {
		super.update("insert into person (name, firstname, box, country, housenumber, municipality, postalcode, street) values ("+person.getName()+ "," +person.getFirstName()+","+person.getAddresses().get(0).getBox()+", "
				+ person.getAddresses().get(0).getCountry()+", "+person.getAddresses().get(0).getHouseNumber()+", "+person.getAddresses().get(0).getMunicipality()+", "+person.getAddresses().get(0).getPostalCode()+", "+person.getAddresses().get(0).getStreet()+")");
//	name, firstname, box, country, housenumber, municipality, postalcode, street
		// TODO implement me
		// hint: super.update(".....
	}

	public List<Person> findByAddress(AddressSearchCriteria addressSearchCriteria) {
		// TODO implement me
		// Finally, use : super.query(query.toString(), parameters.toArray(new
		// String[] {}), new RowMapper<Person>() { ....
		List<Person> people = new ArrayList<Person>();
		
		
		return people;
	}
}