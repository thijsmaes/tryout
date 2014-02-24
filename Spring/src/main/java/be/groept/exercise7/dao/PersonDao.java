package be.groept.exercise7.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import be.groept.exercise7.Person;

@Component
public class PersonDao {

	public Person findPerson(String firstName, String lastName){
		return dummyPeople(firstName+lastName);
	}
	
	public void deletePerson(String firstName, String lastName){
		
	}
	
	private Person dummyPeople(String firstNameLastName){
		Person searched;// = new Person();
		Person one = new Person();
		one.setFirstName("thijs");
		one.setLastName("maes");
		one.setBirthDate(new Date(1980,02,19));
		one.setUserName(firstNameLastName);
		Map<String, Person> map = new HashMap<String, Person>();
		map.put(one.getFirstName()+one.getLastName(), one);
		
		for (String s : map.keySet()){
			if(firstNameLastName.equals(s)){
//				searched = map.get(s);
			}
//			else searched = null;
		}
		searched = one;
		return searched;
	}
}
