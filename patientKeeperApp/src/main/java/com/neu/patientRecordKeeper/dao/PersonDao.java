package com.neu.patientRecordKeeper.dao;

import java.util.List;

import com.neu.patientRecordKeeper.bean.Patient;
import com.neu.patientRecordKeeper.bean.Person;

public interface PersonDao {

	public List<Person> getPerson();

	public void savePerson(Person thePerson);

	public Person getPerson(int theId);
	
	public void deletePerson(int theId);

}
