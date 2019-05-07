package com.neu.patientRecordKeeper.dao;

import java.util.List;

import com.neu.patientRecordKeeper.bean.Patient;

public interface PatientRecordDao {
	
	public List<Patient> getPatientRecord(int theId);
	
	public void savePatient(Patient thePatientRecord);

}
