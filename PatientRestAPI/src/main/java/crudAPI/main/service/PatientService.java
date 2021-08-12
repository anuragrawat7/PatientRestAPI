package crudAPI.main.service;

import java.util.List;

import crudAPI.main.entities.Patient;

public interface PatientService {

	List<Patient> getAllPatient();
	Patient getPatientsById(long id);
	Patient addPatient(Patient patient);
	Patient updatePatient(Patient patient,long id);
	void DeletePatient(long id);
}
