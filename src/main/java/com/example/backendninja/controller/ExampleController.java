package com.example.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.backendninja.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";

	// Primera forma
	@GetMapping("/exampleString")
	// @RequestMapping(value= "/exampleString", method = RequestMethod.GET)
	public String exampleString(Model model) {
		model.addAttribute("person", new Person("Barry", 20));
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}

	// Segunda forma
	@GetMapping("/exampleMVA")
	// @RequestMapping(value = "/exampleMVA", method = RequestMethod.GET)
	public ModelAndView exampleMVA() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("person", new Person("Harrison", 25));
		mav.addObject("people", getPeople());
		return mav;
	}

	private List<Person> getPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Barry", 20));
		people.add(new Person("Harrison", 25));
		people.add(new Person("Eva", 18));
		people.add(new Person("Susan", 21));
		people.add(new Person("Caitlyn", 24));
		return people;
	}

}
