package crudAPI.main.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import crudAPI.main.entities.Patient;
import crudAPI.main.exception.ResourceNotFoundException;
import crudAPI.main.repository.PatientRepository;
import crudAPI.main.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	private PatientRepository patientRepo;
	
	public PatientServiceImpl(PatientRepository patientRepo) {
		super();
		this.patientRepo = patientRepo;
	}

	@Override
	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}

	@Override
	public List<Patient> getAllPatient() {
		return patientRepo.findAll();
	}
	
	@Override
	public Patient getPatientsById(long id) {
		Patient patient = patientRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Patient", "Id", id));
		return patient;
	}

	@Override
	public Patient updatePatient(Patient patient, long id) {
		Patient patient1 = patientRepo.findById(id).orElseThrow(
			() -> new ResourceNotFoundException("Patient", "Id", id));
		patient1.setName(patient.getName());
		patient1.setEmail_Id(patient.getEmail_Id());
		patient1.setPatient_address(patient.getPatient_address());
		patient1.setPhone_number(patient.getPhone_number());
		patient1.setPassword(patient.getPassword());
		patientRepo.save(patient1);
		return patient1;
	}

	@Override
	public void DeletePatient(long id) {
		patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", id));
		
		patientRepo.deleteById(id);
	}

}
