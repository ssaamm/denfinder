package template.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import template.data.geocode.GeocodeService;
import template.m1.LatLon;
import template.scoring.LocationDataPopulator;
import template.scoring.LocationDataWrapper;

@Controller
public class MainController {
	private final int WIDTH_OF_TARGET_BOX = 1;

	@RequestMapping("/map")
	public String map() {

		return "map";
	}

	// Weird thing: this still POSTs to /m2
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String m3input(Model model) {
		model.addAttribute("ideal", new LocationDataWrapper());
		return "m3input";
	}

	@RequestMapping(value = "/m2", method = RequestMethod.POST)
	public String m2submit(@RequestParam Map<String, String> allRequestParams, Model model) {
		List<LocationDataWrapper> locationDataWrappers = new ArrayList<LocationDataWrapper>();

		LocationDataWrapper idealLoc = null;
		if (idealLoc == null) {
			idealLoc = new LocationDataWrapper();
		}
		String address = allRequestParams.get("address");
		idealLoc.setLocation(GeocodeService.getLatLon(address));
		idealLoc.setMedianAge(Double.valueOf(allRequestParams.get("medianAge")));
		idealLoc.setMedianIncome(Integer.valueOf(allRequestParams.get("medianIncome")));
		idealLoc.setSchoolWeight(Double.valueOf(allRequestParams.get("schoolWeight")));
		
		LocationDataPopulator.populate(idealLoc);

		LatLon latLon = idealLoc.getLocation();
		for (int i = -1 * WIDTH_OF_TARGET_BOX; i <= WIDTH_OF_TARGET_BOX; ++i) {
			for (int j = -1 * WIDTH_OF_TARGET_BOX; j <= WIDTH_OF_TARGET_BOX; ++j) {
				LocationDataWrapper toAdd = new LocationDataWrapper(
						latLon.getLatitude() + i * 0.01, latLon.getLongitude()
								+ j * 0.01);
				LocationDataPopulator.populate(toAdd);
				toAdd.setScore(toAdd.compareToIdeal(idealLoc));
				locationDataWrappers.add(toAdd);
			}
		}

		Collections.sort(locationDataWrappers,
				new Comparator<LocationDataWrapper>() {
					@Override
					public int compare(LocationDataWrapper ldw1,
							LocationDataWrapper ldw2) {
						return (int) ((ldw2.getScore() - ldw1.getScore()) * 1000);
					}
				});

		model.addAttribute("locationDataWrappers", locationDataWrappers);
		return "m2submit";
	}
}
