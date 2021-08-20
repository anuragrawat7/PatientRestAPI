package crudAPI.main.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.FutureOrPresent;

@Entity
@Table(name = "Patient")
public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	@Size(min= 3, message = "Name should have atleast 3 characters")	
	private String name;
	
	@Column(name = "address")
	@Size(min= 5, message = "Address should have atleast 5 characters")
	private String address;
	
	@Email
	@Column(name = "email")
	private String email;
	
	//phone_number
	@Column(name = "phone")
	@Size(min = 10,max = 10, message = "Not a valid number")
	private String phone;
	
	@Column(name = "password")
	@Size(min = 8,max = 15, message = "Password: Min-length is 8 and Max-length is 15")
	private String password;
	
	//Date Format : YYYY-MM-DD 
	@Column(name = "appointment")
	@FutureOrPresent
	private LocalDate appointment;

	public Patient(long id, String name, String address, String email, String phone, String password,
			LocalDate appointment) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.appointment = appointment;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getAppointment() {
		return appointment;
	}

	public void setAppointment(LocalDate appointment) {
		this.appointment = appointment;
	}
	
}
