package crudAPI.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import crudAPI.main.entities.Patient;
import crudAPI.main.service.PatientService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	
	private PatientService patientService;

	public AppointmentController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	@GetMapping("/list")
	/* @Query(value="Select * from patients order by date_of_appointment;") */
	public List<Patient> getAllSortedPatient(){
		return patientService.getAllSortedPatient();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Patient> scheduleAppointmentById(@Valid @PathVariable("id") long id, @RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.scheduleAppointmentById(patient, id),HttpStatus.OK);
	}
}
