package com.neu.patientRecordKeeper.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neu.patientRecordKeeper.bean.Patient;
import com.neu.patientRecordKeeper.bean.Person;
import com.neu.patientRecordKeeper.dao.PatientRecordDao;
import com.neu.patientRecordKeeper.dao.PersonDao;
import com.neu.patientRecordKeeper.service.PatientKeeperService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	PatientKeeperService service;

	@RequestMapping("/")
	public String getHomepage(Model model) {
//		List<Person> thePerson = service.getPerson();
		
		Person thePerson = new Person();
		model.addAttribute("person", thePerson);
		return "index";
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

			return "list-patient";
		}
		else
			return "index";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Person thePerson = new Person();

		theModel.addAttribute("person", thePerson);

		return "patient-form";
	}

	@PostMapping("/savePatient")
	public String savePerson(@ModelAttribute("person") Person thePerson) {

		Person patient = service.getPerson(thePerson.getId());

		if (patient == null) {
			// save the person
			service.savePerson(thePerson);
		}

		// use a redirect to prevent duplicate submissions
		return "redirect:/doctor/";
	}

	@GetMapping("/showFormForAddRecord")
	public String showFormForAddRecord(Model theModel) {

		Patient record = new Patient();
		
		theModel.addAttribute("record", record);

		return "record-form";
	}

	@PostMapping("/saveRecord")
	public String saveRecord(@ModelAttribute("record") Patient patientRecord, HttpSession session, Model model) {

//			patientRecord.setPerson(person);
		// save the person
		Person person = (Person) session.getAttribute("person");

		patientRecord.setPerson(person);
		service.savePatient(patientRecord);
		List<Patient> record = service.getPatientRecord(person.getId());
		model.addAttribute("person", person);
		model.addAttribute("patientRecord", record);
		
		return "list-patient";

	}
	
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("personId") int theId,
									Model theModel) {
		
		// get the person from the service
		Person thePerson = service.getPerson(theId);
		
		// set person as a model attribute to pre-populate the form
		theModel.addAttribute("person", thePerson);
		
		// send over to our form
		return "person-form";			
	}
	
	@PostMapping("/showFormForUpdateRecord")
	public String showFormForUpdateRecord(@RequestParam("id") int theId,
									Model theModel) {
		
		// get the person from the service
		Person thePerson = service.getPerson(theId);
		
		// set person as a model attribute to pre-populate the form
		theModel.addAttribute("person", thePerson);
		
		// send over to our form
		return "person-form";			
	}
	
	@ModelAttribute("role")
	   public Map<String, String> getRole() {
	      Map<String, String> role = new HashMap<String, String>();
	      role.put("Doctor", "Doctor");
	      role.put("Patient", "Patient");
	      return role;
	   }

}
