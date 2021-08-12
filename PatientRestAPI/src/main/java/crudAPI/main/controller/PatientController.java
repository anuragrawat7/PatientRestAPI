package crudAPI.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crudAPI.main.entities.Patient;
import crudAPI.main.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	// Gives all the patients details
	@GetMapping
	public List<Patient> getAllPatient(){
		return patientService.getAllPatient();
	}
	
	// Give a patient details of specific id.
	@GetMapping("{id}")
	public ResponseEntity<Patient> getPatientsById(@PathVariable("id") long id){
		return new ResponseEntity<Patient>(patientService.getPatientsById(id), HttpStatus.OK);
	}
	
	// Creates a new Patient record.
	@PostMapping
	public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.addPatient(patient), HttpStatus.CREATED);
	}
	
	// To update patients details by specifying id.
	@PutMapping("{id}")
	public ResponseEntity<Patient> updatePatient(@Valid @PathVariable("id") long id, @RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.updatePatient(patient, id),HttpStatus.OK);
	}
	
	// To delete a record of a patient.
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePatient(@PathVariable("id") long id){
		patientService.DeletePatient(id);
		return new ResponseEntity<String>("Patient Data Deleted Successfully", HttpStatus.OK);
	}
}
