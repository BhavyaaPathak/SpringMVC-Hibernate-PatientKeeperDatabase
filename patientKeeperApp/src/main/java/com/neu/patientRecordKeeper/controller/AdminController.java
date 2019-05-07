package com.neu.patientRecordKeeper.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

import com.neu.patientRecordKeeper.bean.Person;
import com.neu.patientRecordKeeper.dao.PersonDao;
import com.neu.patientRecordKeeper.service.PatientKeeperService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PatientKeeperService patientKeeperService;

	@GetMapping("/list")
	public String listPerson(Model theModel) {

		// get person from db
		List<Person> thePerson = patientKeeperService.getPerson();

		// add to the spring model
		theModel.addAttribute("person", thePerson);

		return "list-person";
	}

	@GetMapping("/list/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Person thePerson = new Person();
		theModel.addAttribute("person", thePerson);

		return "person-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("personId") int theId, Model theModel) {

		// get the person from the service
		Person thePerson = patientKeeperService.getPerson(theId);

		// set person as a model attribute to pre-populate the form
		theModel.addAttribute("person", thePerson);

		// send over to our form
		return "person-form";
	}

	@PostMapping("/save")
	public String savePerson(@ModelAttribute("person") Person thePerson) {

		// save the person
		patientKeeperService.savePerson(thePerson);

		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("personId") int theId) {

		// delete the person
		patientKeeperService.deletePerson(theId);

		// redirect to /person/list
		return "redirect:/admin/list";

	}

	@ModelAttribute("role")
	public Map<String, String> getRole() {
		Map<String, String> role = new HashMap<String, String>();
		role.put("Doctor", "Doctor");
		role.put("Patient", "Patient");
		return role;
	}
}
