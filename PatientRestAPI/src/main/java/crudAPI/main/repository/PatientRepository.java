package crudAPI.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import crudAPI.main.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
