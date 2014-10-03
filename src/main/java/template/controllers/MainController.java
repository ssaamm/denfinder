package template.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import template.data.census.CensusService;
import template.data.education.EducationService;
import template.m1.LatLonForm;

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
	
	@RequestMapping(value = "/m1", method = RequestMethod.GET)
	public String m1input(Model model) {
		model.addAttribute("latLonForm", new LatLonForm());
		return "m1input";
	}

	@RequestMapping(value = "/m1", method = RequestMethod.POST)
	public String m1submit(@ModelAttribute LatLonForm latLonForm, Model model) {
		model.addAttribute("message", latLonForm.getLatitude() + " " + latLonForm.getLongitude());
		model.addAttribute("schools", EducationService.getSchools(latLonForm.getLatitude(),
				latLonForm.getLongitude(), 10));
		return "m1submit";
	}
}
