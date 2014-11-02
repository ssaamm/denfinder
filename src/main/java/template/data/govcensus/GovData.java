package template.data.govcensus;

public class GovData {
	public Integer medianIncome;
	public Double medianAge;
	public Integer marriedCoupleFamilyHouseholds;
	public Integer totalHouseholds;

	public GovData(Integer medianIncome, Double medianAge, Integer marriedCoupleFamilyHouseholds,
			Integer totalHouseholds) {
		this.medianIncome = medianIncome;
		this.medianAge = medianAge;
		this.marriedCoupleFamilyHouseholds = marriedCoupleFamilyHouseholds;
		this.totalHouseholds = totalHouseholds;
	}
}
