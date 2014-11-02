package template.scoring;

import template.data.education.EducationService;
import template.data.fipsconversion.FipsCode;
import template.data.fipsconversion.FipsConversionService;
import template.data.govcensus.GovCensusService;
import template.data.govcensus.GovData;
import template.data.publictransit.PublicTransitService;

public class LocationDataPopulator {
	public static void populate(LocationDataWrapper ldw) {
		Double latitude = ldw.getLocation().getLatitude();
		Double longitude = ldw.getLocation().getLongitude();
		FipsCode fipsCode = FipsConversionService.getFipsCode(latitude, longitude);
		
		ldw.setTransitScore(PublicTransitService.getTransitScore(latitude, longitude));
		// magic number alert
		ldw.setSchools(EducationService.getSchools(latitude, longitude, 0, 2));

		GovData govData = GovCensusService.getCensusData(fipsCode.state, fipsCode.county,
				fipsCode.tract, fipsCode.blockGroup);
		ldw.setMedianIncome(govData.medianIncome);
		ldw.setMedianAge(govData.medianAge);
		ldw.setMarriedCoupleFamilyHouseholds(govData.marriedCoupleFamilyHouseholds);
		ldw.setTotalHouseholds(govData.totalHouseholds);
	}
}
