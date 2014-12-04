package template.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import template.data.geocode.GeocodeService;
import template.m1.LatLon;
import template.scoring.LocationDataPopulator;
import template.scoring.LocationDataWrapper;

@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("ideal", new LocationDataWrapper());
		return "index";
	}

	@RequestMapping(value = "/score")
	public @ResponseBody ScoreResponse getScore(@RequestParam Map<String, String> allRequestParams,
			Model model) {
		LocationDataWrapper idealLoc = new LocationDataWrapper();
		idealLoc.setMedianAge(Double.valueOf(allRequestParams.get("medianAge")));
		idealLoc.setMedianIncome(Integer.valueOf(allRequestParams.get("medianIncome")));
		idealLoc.setSchoolWeightInput(Double.valueOf(allRequestParams.get("schoolWeightInput")));
		idealLoc.setTransitWeightInput(Double.valueOf(allRequestParams.get("transitWeightInput")));

		Double lat = Double.valueOf(allRequestParams.get("lat")), lon = Double
				.valueOf(allRequestParams.get("lon"));
		LocationDataWrapper loc = new LocationDataWrapper(lat, lon);
		LocationDataPopulator.populate(loc);
		loc.compareToIdeal(idealLoc);

		ScoreResponse sr = new ScoreResponse(lat, lon);
		sr.setScore(loc.getScore());
		return sr;
	}

	@RequestMapping(value = "/map", method = RequestMethod.POST)
	public String map(@RequestParam Map<String, String> allRequestParams, Model model) {
		LocationDataWrapper idealLoc = null;
		if (idealLoc == null) {
			idealLoc = new LocationDataWrapper();
		}
		String address = allRequestParams.get("address");
		idealLoc.setAddress(address);
		idealLoc.setLocation(GeocodeService.getLatLon(address));
		idealLoc.setMedianAge(Double.valueOf(allRequestParams.get("medianAge")));
		idealLoc.setMedianIncome(Integer.valueOf(allRequestParams.get("medianIncome")));
		idealLoc.setSchoolWeightInput(Double.valueOf(allRequestParams.get("schoolWeightInput")));
		idealLoc.setTransitWeightInput(Double.valueOf(allRequestParams.get("transitWeightInput")));

		LatLon latLon = idealLoc.getLocation();

		String idealLocData = String.format(
				"{latitude: %.4f, longitude: %.4f, medianAge: %.4f, schoolWeight: %.4f, "
				+ "medianIncome: %d, transitWeight: %.4f}",
				idealLoc.getLocation().getLatitude(), idealLoc.getLocation().getLongitude(),
				idealLoc.getMedianAge(),idealLoc.getSchoolWeight(), idealLoc.getMedianIncome(),
				idealLoc.getTransitWeight()
				);
		model.addAttribute("idealData",idealLocData);
		model.addAttribute("ideal", new LocationDataWrapper());
		model.addAttribute("locData", "");
		model.addAttribute("latitude", latLon.getLatitude());
		model.addAttribute("longitude", latLon.getLongitude());
		model.addAttribute("addressStr",address);
		return "map";
	}
}
