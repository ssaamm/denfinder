package template.scoring;


public class Score {
	private Double transitScore = null;
	private Double schoolScore = null;
	private Double incomeScore = null;
	private Double ageScore = null;
	private Double locationScore = null;
	private Double transitWeight = 1.0;
	private Double locationWeight =1.0;
	private Double schoolWeight = 1.0;
	private Double ageWeight =1.0;
	private Double householdWeight =1.0;
	private Double incomeWeight =4.0;
	
	public Double getSchoolWeight() {
		return schoolWeight;
	}

	public void setSchoolWeight(Double schoolWeight) {
		this.schoolWeight = schoolWeight;
	}

	public Double getTransitWeight() {
		return transitWeight;
	}

	public void setTransitWeight(Double transitWeight) {
		this.transitWeight = transitWeight;
	}

	Score(){
		transitScore=0.0;
		schoolScore=0.0;
		incomeScore=0.0;
		ageScore=0.0;
		locationScore=0.0;
	}
	
	void compare(LocationDataWrapper current, LocationDataWrapper ideal){
		
		try {
			//transit score
			transitScore = 0.01 * current.getTransitScore() * ideal.getTransitWeight();
			
			//school score
			if (current.getSchools().size() >= 2) {
				schoolScore = (current.getSchools().get(0).getQuality() * .07 + current.getSchools().get(1).getQuality() * .03)
						* ideal.getSchoolWeight();
			}
			
			//income score
			if (ideal.getMedianIncome() != null && current.getMedianIncome() != null) {
				incomeScore = (1 - (double)Math.abs(ideal.getMedianIncome() - current.getMedianIncome()) / (double)ideal.getMedianIncome())
						* this.incomeWeight;
			}
			
			//age score
			if (ideal.getMedianAge() != null && current.getMedianAge() != null) {
				ageScore = (1 - Math.abs(ideal.getMedianAge() - current.getMedianAge()) / ideal.getMedianAge())
						* this.ageWeight;
			}
		} catch (ArithmeticException e) {
			// TODO: fix this bad exception handling
			e.printStackTrace();
		}
		
	}
	
	public Double getTransitScore() {
		return transitScore;
	}
	public Double getSchoolScore() {
		return schoolScore;
	}
	public Double getIncomeScore() {
		return incomeScore;
	}
	public Double getAgeScore() {
		return ageScore;
	}
	public Double getLocationScore() {
		return locationScore;
	}
	public Double getTotalScore(){
		Double sum = 0.0;
		sum += transitScore;
		sum += schoolScore;
		sum += incomeScore;
		sum += ageScore;
		sum += locationScore;
		return sum;
	}
	
	public String toString(){
		return "Total Score : " + this.getTotalScore() + "<br />" +
				"--transit: "+this.getTransitScore() + "<br />" +
				"--school:  "+this.getSchoolScore() + "<br />" +
				"--income:  "+this.getIncomeScore() + "<br />" +
				"--age:     "+this.getAgeScore();
	}
	
	
	
}
