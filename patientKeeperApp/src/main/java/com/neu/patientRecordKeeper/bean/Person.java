package com.neu.patientRecordKeeper.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
//	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String email;
	
	@Column(name="SSN")
//	@Min(9)
//	@Max(9)
	private String SSN;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="role")
	private String role;
	
	@OneToMany(mappedBy="person")
	private List<Patient> patient;
	
	@OneToOne(mappedBy="person")
	private User user;
	
	public Person() {
	}
	
	public Person(int id, String firstName, String lastName, String email, String sSN, String dob, String role, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.SSN = sSN;
		this.dob = dob;
		this.role = role;
		this.gender = gender;
	}



//	public enum Role {
//        Doctor("Doctor"),
//        Patient("Patient");
//
//        private String value;
//
//        private Role(String value) {
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        @Override
//        public String toString() {
//            return super.toString(); //To change body of generated methods, choose Tools | Templates.
//        }
//    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", SSN=" + SSN + ", dob=" + dob + ", gender=" + gender + ", role=" + role + "]";
	}

	

}
