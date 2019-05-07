package com.neu.patientRecordKeeper.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.patientRecordKeeper.bean.Patient;
import com.neu.patientRecordKeeper.bean.Person;
import com.neu.patientRecordKeeper.service.PatientKeeperService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientKeeperService service;
	
	@RequestMapping("/")
	public String getHomepage(Model model) {
//		List<Person> thePerson = service.getPerson();
		
		Person thePerson = new Person();
		model.addAttribute("person", thePerson);
		return "index-patient";
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String findPerson(Model theModel, @ModelAttribute("person") Person thePerson, HttpSession session) {

		// get person from db
		Person person = service.getPerson(thePerson.getId());
		if (person.getRole().equals("Patient")) {
			List<Patient> record = service.getPatientRecord(thePerson.getId());
			session.setAttribute("person", person);
			theModel.addAttribute("person", person);
			theModel.addAttribute("patientRecord", record);

			return "list-patient-patient";
		}
		else
			return "index-patient";

	}

}
