package com.neu.patientRecordKeeper.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.neu.patientRecordKeeper.bean.Patient;
import com.neu.patientRecordKeeper.bean.Person;
import com.neu.patientRecordKeeper.dao.PatientRecordDao;
import com.neu.patientRecordKeeper.dao.PatientRecordDaoImpl;
import com.neu.patientRecordKeeper.dao.PersonDao;
import com.neu.patientRecordKeeper.dao.PersonDaoImpl;

@EnableTransactionManagement
@Service
public class PatientKeeperServiceImpl implements PatientKeeperService {
	
	@Autowired
	PersonDao personDao;
	
	@Autowired
	PatientRecordDao patientRecordDao;
	
	@Transactional
	@Override
	public List<Person> getPerson() {
		return personDao.getPerson();
	}
	
	@Transactional
	@Override
	public void savePerson(Person thePerson) {
		personDao.savePerson(thePerson);
	}
	
	@Transactional
	@Override
	public Person getPerson(int theId) {
		return personDao.getPerson(theId);
	}
	
	@Transactional
	@Override
	public void deletePerson(int theId) {
		personDao.deletePerson(theId);
	}
	
	@Transactional
	@Override
	public List<Patient> getPatientRecord(int theId) {
		return patientRecordDao.getPatientRecord(theId);
	}
	
	@Transactional
	@Override
	public void savePatient(Patient thePatientRecord) {
		patientRecordDao.savePatient(thePatientRecord);
	}

}
