package template.data.census;

import org.json.JSONObject;

public class PlaceMapper {
	public static Place map(JSONObject jsonPlace) {
		Place place = new Place();
		place.name = jsonPlace.getString("Placename");
		place.fullName = jsonPlace.getString("PlacenameFull");
		place.percentPacificIslander = new Double(jsonPlace.getString("PctNatHawOth"));
		place.percentAsian = new Double(jsonPlace.getString("PctAsian"));
		place.stateApAbbrev = jsonPlace.getString("StateAP");
		place.peoplePerSquareMile = new Double(jsonPlace.getString("PopSqMi"));
		place.diversityIndex = new Double(jsonPlace.getString("USATDiversityIndex"));
		place.totalSquareMiles = new Double(jsonPlace.getString("TotSqMi"));
		place.percentAmericanIndian = new Double(jsonPlace.getString("PctAmInd"));
		place.percentNonHispanicWhite = new Double(jsonPlace.getString("PctNonHispWhite"));
		place.statePostal = jsonPlace.getString("StatePostal");
		place.percentBlack = new Double(jsonPlace.getString("PctBlack"));
		place.percentChange = new Double(jsonPlace.getString("PctChange").equals("") ? "0" : jsonPlace.getString("PctChange"));
		place.percentHispanic = new Double(jsonPlace.getString("PctHisp"));
		place.waterSquareMiles = new Double(jsonPlace.getString("WaterSqMi"));
		place.percentVacant = new Double(jsonPlace.getString("PctVacant"));
		place.fips = jsonPlace.getString("FIPS");
		place.percentOther = new Double(jsonPlace.getString("PctOther"));
		place.percentTwoOrMoreRaces = new Double(jsonPlace.getString("PctTwoOrMore"));
		place.housingUnits = new Integer(jsonPlace.getString("HousingUnits"));
		place.gnis = jsonPlace.getString("GNIS");
		place.population = new Integer(jsonPlace.getString("Pop"));
		place.landSquareMiles = new Double(jsonPlace.getString("LandSqMi"));
		place.latitude = new Double(jsonPlace.getString("Lat"));
		place.longitude = new Double(jsonPlace.getString("Long"));
		place.percentNonHispanic = new Double(jsonPlace.getString("PctNonHisp"));
		place.percentWhite = new Double(jsonPlace.getString("PctWhite"));
		return place;
	}
}
