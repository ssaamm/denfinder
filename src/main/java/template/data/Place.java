package template.data;

public class Place {
	public String name;
	public String fullName;
	public double percentAsian;
	public double peoplePerSquareMile;
	public double diversityIndex;
	public double totalSquareMiles;
	public double percentAmericanIndian;
	public double percentNonHispanicWhite;
	public String statePostal;
	public double percentBlack;
	public double percentChange;//  Percentage change in population for an area from Census 2000 to Census 2010
	public double percentHispanic;
	public double waterSquareMiles;
	public double percentVacant;
	public String fips;
	public double percentOther;
	public double percentTwoOrMoreRaces;
	public int housingUnits;
	public String gnis;
	public int population;
	public double landSquareMiles;
	public double longitude;
	public double latitude;
	public double percentNonHispanic;
	public double percentWhite;
	public double percentPacificIslander;
	public String stateApAbbrev;
	
	@Override
	public String toString() {
		return "Place [name=" + name + ", fullName=" + fullName
				+ ", percentAsian=" + percentAsian + ", peoplePerSquareMile="
				+ peoplePerSquareMile + ", diversityIndex=" + diversityIndex
				+ ", totalSquareMiles=" + totalSquareMiles
				+ ", percentAmericanIndian=" + percentAmericanIndian
				+ ", percentNonHispanicWhite=" + percentNonHispanicWhite
				+ ", statePosal=" + statePostal + ", percentBlack="
				+ percentBlack + ", percentChange=" + percentChange
				+ ", percentHispanic=" + percentHispanic
				+ ", waterSquareMiles=" + waterSquareMiles + ", percentVacant="
				+ percentVacant + ", fips=" + fips + ", percentOther="
				+ percentOther + ", percentTwoOrMoreRaces="
				+ percentTwoOrMoreRaces + ", housingUnits=" + housingUnits
				+ ", gnis=" + gnis + ", population=" + population
				+ ", landSquareMiles=" + landSquareMiles + ", longitude="
				+ longitude + ", latitude=" + latitude
				+ ", percentNonHispanic=" + percentNonHispanic
				+ ", percentWhite=" + percentWhite + "]";
	}
}
