package be.groept.hibernate.exercise1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO implement me
		return null;
	}

	public void removePerson(Person person) {
		// TODO implement me
		// hint: super.update(".....
	}

	public void savePerson(Person person) {
		// TODO implement me
		// hint: super.update(".....
	}

	public List<Person> findByAddress(AddressSearchCriteria addressSearchCriteria) {
		// TODO implement me
		// Finally, use : super.query(query.toString(), parameters.toArray(new
		// String[] {}), new RowMapper<Person>() { ....
		return null;
	}
}