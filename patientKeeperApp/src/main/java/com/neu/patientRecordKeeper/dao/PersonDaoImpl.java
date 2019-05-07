package com.neu.patientRecordKeeper.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neu.patientRecordKeeper.bean.Person;
import com.neu.patientRecordKeeper.bean.User;

@Repository
public class PersonDaoImpl implements PersonDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Person> getPerson() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Person> theQuery = currentSession.createQuery("from Person", Person.class);

		// execute query and get result list
		List<Person> person = theQuery.getResultList();

		// return the results
		return person;
	}

	@Override
	public void savePerson(Person thePerson) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		User user = new User();
		user.setUsername(thePerson.getFirstName()+thePerson.getSSN().substring(7,9));
		user.setPassword(thePerson.getLastName());
		user.setPerson(thePerson);
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(thePerson);
		currentSession.saveOrUpdate(user);

	}

	@Override
	public Person getPerson(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Person thePerson = currentSession.get(Person.class, theId);

		return thePerson;
	}

	@Override
	public void deletePerson(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Person where id=:personId");
		theQuery.setParameter("personId", theId);

		theQuery.executeUpdate();
	}

}
