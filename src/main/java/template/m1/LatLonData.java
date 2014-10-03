package template.m1;

import java.util.List;

import template.data.census.Place;
import template.data.education.School;

public class LatLonData {
	private LatLon latLon;
	private List<Place> places;
	private List<School> schools;

	public LatLonData(LatLon latLon, List<Place> places, List<School> schools) {
		super();
		this.latLon = latLon;
		this.places = places;
		this.schools = schools;
	}

	public LatLon getLatLon() {
		return latLon;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public List<School> getSchools() {
		return schools;
	}
}
