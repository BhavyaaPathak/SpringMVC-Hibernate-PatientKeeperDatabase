package com.neu.patientRecordKeeper.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.neu.patientRecordKeeper.bean.Patient;

@Repository
public class PatientRecordDaoImpl implements PatientRecordDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Patient> getPatientRecord(int theId) {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		String SQL_QUERY ="from Patient as p where p.person.id=" + theId;
		// create a query ... sort by last name
		
//		Query<Patient> theQuery = currentSession.createQuery("from Patient", Patient.class);

		
		Query<Patient> theQuery = currentSession.createQuery(SQL_QUERY, Patient.class);

		// execute query and get result list
		List<Patient> person = theQuery.getResultList();

		// return the results
		return person;
	}

	@Override
	public void savePatient(Patient thePatientRecord) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(thePatientRecord);

	}

}
