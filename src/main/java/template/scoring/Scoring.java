package template.scoring;

public class Scoring {
	private Location desiredLocation;
	public enum Factor {
		    EDUCATION, INCOME, MARITAL, AGE,
		    TRANSIT, CRIME_RATE 
		}
	double getScore(Location l, Location against){
		ArrayList<SubScore> subScores = new ArrayList<SubScore>();
		
		
		//education
		SubScore edu = new SubScore(l.getWeight(Factor.EDUCATION),getRawEduScore(l.latlon),Factor.EDUCATION.toString());
		subScores.add(edu);
		//$$
		SubScore income = new SubScore(l.getWeight(Factor.INCOME),getRawIncomeScore(l.latlon),Factor.INCOME.toString());
		subScores.add(edu);
		//marital
		SubScore edu = new SubScore(l.getWeight(Factor.MARITAL),getRawMaritalScore(l.latlon),Factor.MARITAL.toString());
		subScores.add(edu);
		//age
		SubScore edu = new SubScore(l.getWeight("education"),getRawEduScore(l.latlon),"education");
		subScores.add(edu);
		//public transit
		SubScore edu = new SubScore(l.getWeight("education"),getRawEduScore(l.latlon),"education");
		subScores.add(edu);
		//crime rate
		SubScore edu = new SubScore(l.getWeight("education"),getRawEduScore(l.latlon),"education");
		subScores.add(edu);
		return 0.0;
	}
	
	double getScore(Location l){
		return getScore(l,desiredLocation);
	}
	
	void setDesiredLocation(Location l){
		desiredLocation = l;
	}
	
	double getRawEduScore(LatLon postition){
		
	}
	double getRawIncomeScore(LatLon postition){
		
	}
	double getRawCrimeRateScore(LatLon postition){
		
	}
	double getRawAgeScore(LatLon postition){
		
	}
	double getRawPublicTransitScore(LatLon postition){
		
	}
}
