package template.scoring;

import java.util.List;

import template.data.education.School;
import template.m1.LatLon;

public class LocationDataWrapper {
	private LatLon location = null;
	private List<School> schools = null;
	private Double transitScore = null;
	private Integer medianIncome = null;
	private Double medianAge = null;
	private Integer marriedCoupleFamilyHouseholds = null;
	private Integer totalHouseholds = null;
	private String address = null;
	private Score score = null;
	
	//for hacks
	private Double schoolWeightInput = null;
	private Double transitWeightInput = null;
	
	public Double getSchoolWeightInput() {
		return schoolWeightInput;
	}

	public void setSchoolWeightInput(Double schoolWeightInput) {
		this.schoolWeightInput = schoolWeightInput;
		this.setSchoolWeight(schoolWeightInput);
	}
	
	public Double getTransitWeightInput() {
		return transitWeightInput;
	}

	public void setTransitWeightInput(Double transitWeightInput) {
		this.transitWeightInput = transitWeightInput;
		this.setTransitWeight(transitWeightInput);
	}

	private void setTransitWeight(Double transitWeight) {
		this.score.setTransitWeight(transitWeight);		
	}
	public Double getTransitWeight(){
		return this.score.getTransitWeight();
	}

	public Double getTransitScore() {
		return transitScore;
	}

	public void setTransitScore(Double transitScore) {
		this.transitScore = transitScore;
	}

	public void setTransitScore(Integer transitScore2) {
		// TODO Auto-generated method stub
		this.transitScore = (double)transitScore2;
	}

	public Double getSchoolWeight() {
		return score.getSchoolWeight();
	}

	public void setSchoolWeight(Double schoolWeight) {
		this.score.setSchoolWeight(schoolWeight);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocationDataWrapper(double lat, double lon) {
		this.location = new LatLon(lat, lon);
		this.score = new Score();
	}
	
	public LocationDataWrapper() {
		this.score = new Score();
	}

	@Override
	public String toString() {
		return this.score.toString();/*LocationDataWrapper [location=" + location + ", transitScore=" + transitScore
				+ ", schools=" + schools + ", medianIncome=" + medianIncome + ", medianAge="
				+ medianAge + ", marriedCoupleFamilyHouseholds=" + marriedCoupleFamilyHouseholds
				+ ", totalHouseholds=" + totalHouseholds + ", score=" + score + "]";*/
	}

	public LatLon getLocation() {
		return location;
	}

	public void setLocation(LatLon location) {
		this.location = location;
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
		return score.getTotalScore();
	}

	public void compareToIdeal(LocationDataWrapper ideal) {
		this.score.compare(this, ideal);
		return;
	}

}
