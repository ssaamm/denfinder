package template.util;

public class ApiKeys {
	public static final String cEducationKey = System.getenv("DF_EDUCATION_KEY") == null ? ""
			: System.getenv("DF_EDUCATION_KEY"),
			cCensusKey = System.getenv("DF_CENSUS_KEY") == null ? "" : System
					.getenv("DF_CENSUS_KEY"),
			cGovCensusKey = System.getenv("DF_GOV_CENSUS_KEY") == null ? "" : System
					.getenv("DF_GOV_CENSUS_KEY"),
			cWalkscoreKey = System.getenv("DF_WALKSCORE_KEY") == null ? "" : System
					.getenv("DF_WALKSCORE_KEY"), cGoogleGeocodeKey = System
					.getenv("DF_GOOG_GEOCODE_KEY") == null ? "" : System
					.getenv("DF_GOOG_GEOCODE_KEY");
}
