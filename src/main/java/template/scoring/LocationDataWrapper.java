package template.scoring;

import java.util.List;

import template.data.education.School;
import template.data.geocode.GeocodeService;
import template.m1.LatLon;

public class LocationDataWrapper {
	private LatLon location = null;
	private Double locationWeight =1.0;
	private Integer transitScore = null;
	private Double transitWeight =1.0;
	private List<School> schools = null;
	private Double schoolWeight =1.0;
	private Integer medianIncome = null;
	private Double incomeWeight =1.0;
	private Double medianAge = null;
	private Double ageWeight =1.0;
	private Integer marriedCoupleFamilyHouseholds = null;
	private Double householdWeight =1.0;
	private Integer totalHouseholds = null;
	private String address = null;
	private Double score = null;

	public Double getSchoolWeight() {
		return schoolWeight;
	}

	public void setSchoolWeight(Double schoolWeight) {
		this.schoolWeight = schoolWeight;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocationDataWrapper(double lat, double lon) {
		this.location = new LatLon(lat, lon);
	}
	
	//address is address, zipcode, or city name
	public LocationDataWrapper(String address){
		setLocation(address);
	}
	
	public LocationDataWrapper() {
		
	}

	//address is address, zipcode, or city name
	public void setLocation(String addr){
		this.address = addr;
		setLocation();
	}
	public void setLocation(){
		//TODO call google, string to lat lon
		this.location = GeocodeService.getLatLon(address);
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

	public Double compareToIdeal(LocationDataWrapper ideal) {
		this.score = 0.0;
		

	// private LatLon location = null;
		
	// private Integer transitScore = null;
		try {
			score += (1 - Math.abs(ideal.transitScore - this.transitScore)/ideal.transitScore)*this.transitWeight;
		} catch (ArithmeticException e) {
			// TODO: fix this bad exception handling
			e.printStackTrace();
		}
	// private List<School> schools = null;
		score += (schools.get(0).getQuality()*.7 + schools.get(1).getQuality()*.3)*this.schoolWeight;
	// private Integer medianIncome = null;
		score += (1 - Math.abs(ideal.medianIncome - this.medianIncome)/ideal.medianIncome)*this.incomeWeight;
	// private Double medianAge = null;
		score += (1 - Math.abs(ideal.medianAge - this.medianAge)/ideal.medianAge)*this.ageWeight;
	// private Integer marriedCoupleFamilyHouseholds = null;
		
	// private Integer totalHouseholds = null;
		
		return score;
	}
}
