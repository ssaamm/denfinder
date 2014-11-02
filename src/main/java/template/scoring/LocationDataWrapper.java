package template.scoring;

import java.util.List;

import template.data.education.School;
import template.m1.LatLon;

public class LocationDataWrapper {
	private LatLon location = null;
	private Integer transitScore = null;
	private List<School> schools = null;
	private Integer medianIncome = null;
	private Double medianAge = null;
	private Integer marriedCoupleFamilyHouseholds = null;
	private Integer totalHouseholds = null;
	private Double score = null;

	public LocationDataWrapper(double lat, double lon) {
		this.location = new LatLon(lat, lon);
	}

	@Override
	public String toString() {
		return "LocationDataWrapper [location=" + location + ", transitScore=" + transitScore
				+ ", schools=" + schools + ", medianIncome=" + medianIncome + ", medianAge="
				+ medianAge + ", marriedCoupleFamilyHouseholds=" + marriedCoupleFamilyHouseholds
				+ ", totalHouseholds=" + totalHouseholds + ", score=" + score + "]";
	}

	public LatLon getLocation() {
		return location;
	}

	public void setLocation(LatLon location) {
		this.location = location;
	}

	public Integer getTransitScore() {
		return transitScore;
	}

	public void setTransitScore(Integer transitScore) {
		this.transitScore = transitScore;
	}

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	public Integer getMedianIncome() {
		return medianIncome;
	}

	public void setMedianIncome(Integer medianIncome) {
		this.medianIncome = medianIncome;
	}

	public Double getMedianAge() {
		return medianAge;
	}

	public void setMedianAge(Double medianAge) {
		this.medianAge = medianAge;
	}

	public Integer getMarriedCoupleFamilyHouseholds() {
		return marriedCoupleFamilyHouseholds;
	}

	public void setMarriedCoupleFamilyHouseholds(Integer marriedCoupleFamilyHouseholds) {
		this.marriedCoupleFamilyHouseholds = marriedCoupleFamilyHouseholds;
	}

	public Integer getTotalHouseholds() {
		return totalHouseholds;
	}

	public void setTotalHouseholds(Integer totalHouseholds) {
		this.totalHouseholds = totalHouseholds;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
}
