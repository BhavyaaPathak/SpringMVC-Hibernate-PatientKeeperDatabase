package com.neu.patientRecordKeeper.service;

import java.util.List;

import com.neu.patientRecordKeeper.bean.Patient;
import com.neu.patientRecordKeeper.bean.Person;

public interface PatientKeeperService {

	public List<Person> getPerson();

	public void savePerson(Person thePerson);

	public Person getPerson(int theId);

	public void deletePerson(int theId);

	public List<Patient> getPatientRecord(int theId);

	public void savePatient(Patient thePatientRecord);

}
