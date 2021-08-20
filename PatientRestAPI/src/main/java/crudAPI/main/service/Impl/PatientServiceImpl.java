package crudAPI.main.service.Impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	public List<Patient> getAllPatients() {
		return patientRepo.findAll();
	}
	
	@Override
	public Patient getPatientById(long id) {
		Patient patient = patientRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Patient", "Id", id));
		return patient;
	}

	@Override
	public Patient updatePatient(Patient patient, long id) {
		Patient patient1 = patientRepo.findById(id).orElseThrow(
			() -> new ResourceNotFoundException("Patient", "Id", id));
		patient1.setName(patient.getName());
		patient1.setEmail(patient.getEmail());
		patient1.setAddress(patient.getAddress());
		patient1.setPhone(patient.getPhone());
		patient1.setPassword(patient.getPassword());
		patientRepo.save(patient1);
		return patient1;
	}

	@Override
	public void deletePatient(long id) {
		patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", id));
		
		patientRepo.deleteById(id);
	}

	@Override
	public List<Patient> getAllSortedPatient() {
		return patientRepo.findAll(Sort.by(Direction.ASC, "appointment"));
	}

	@Override
	public Patient scheduleAppointmentById(Patient patient, long id) {
		Patient patientdate = patientRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Patient", "Id", id));
		patientdate.setAppointment(patient.getAppointment());
		patientRepo.save(patientdate);
		return patientdate;
	}

	
}
