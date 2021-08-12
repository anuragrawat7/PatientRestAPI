package crudAPI.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Patients")
public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	@Size(min= 3, message = "Name should have atleast 3 characters")	
	private String name;
	
	@Column(name = "patient_address")
	@Size(min= 3, message = "Address should have atleast 10 characters")
	private String patient_address;
	
	@Email
	@Column(name = "email_Id")
	private String email_Id;
	
	@Column(name = "phone_number")
	@Size(min = 10,max = 10, message = "Not a valid number")
	private String phone_number;
	
	@Column(name = "password")
	@Size(min = 8,max = 15, message = "Password: Min-length is 8 and Max-length is 15")
	private String password;

	public Patient(long id, String name, String patient_address, String email_Id, String phone_number,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.patient_address = patient_address;
		this.email_Id = email_Id;
		this.phone_number = phone_number;
		this.password = password;
	}

	public Patient() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatient_address() {
		return patient_address;
	}

	public void setPatient_address(String patient_address) {
		this.patient_address = patient_address;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
