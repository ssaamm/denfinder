package template.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import template.data.census.CensusService;
import template.data.education.EducationService;
import template.data.fipsconversion.FipsConversionService;

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
		model.addAttribute("schools", EducationService.getSchools(31.5472, -97.1139, 15));
		return "education";
	}

	@RequestMapping("census")
	public String census(Model model) {
		model.addAttribute("places",
				CensusService.getPlaces(FipsConversionService.getCountyFipsCode(31.5472, -97.1139)));
		return "census";
	}
}
