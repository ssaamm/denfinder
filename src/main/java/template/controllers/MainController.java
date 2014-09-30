package template.controllers;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import template.data.census.CensusService;
import template.data.education.EducationService;
import template.data.education.School;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {

		return "index";
	}
	
	@RequestMapping("/map")
	public String map() {

		return "map";
	}
	
	@RequestMapping("education")
	public String education(Model model) {
		model.addAttribute("schools", EducationService.getSchools(35.64, -120.68, 15));
		return "education";
	}
	
	@RequestMapping("census")
	public String census(Model model) {
		model.addAttribute("places", CensusService.getPlaces("DE"));
		return "census";
	}
}
