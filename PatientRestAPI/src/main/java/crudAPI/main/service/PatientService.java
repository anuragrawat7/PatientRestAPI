package crudAPI.main.service;

import java.util.List;

import crudAPI.main.entities.Patient;

public interface PatientService {

	List<Patient> getAllPatients();
	Patient getPatientById(long id);
	Patient addPatient(Patient patient);
	Patient updatePatient(Patient patient,long id);
	void deletePatient(long id);
	List<Patient> getAllSortedPatient();
	Patient scheduleAppointmentById(Patient patient, long id);
}
