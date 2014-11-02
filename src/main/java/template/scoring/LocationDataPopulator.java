package template.scoring;

import template.data.education.EducationService;
import template.data.fipsconversion.FipsCode;
import template.data.fipsconversion.FipsConversionService;
import template.data.govcensus.GovCensusService;
import template.data.publictransit.PublicTransitService;

public class LocationDataPopulator {
	public static void populate(LocationDataWrapper ldw) {
		Double latitude = ldw.getLocation().getLatitude();
		Double longitude = ldw.getLocation().getLongitude();
		FipsCode fipsCode = FipsConversionService.getFipsCode(latitude, longitude);
		
		ldw.setTransitScore(PublicTransitService.getTransitScore(latitude, longitude));
		// magic number alert
		ldw.setSchools(EducationService.getSchools(latitude, longitude, 15));
		ldw.setMedianIncome(GovCensusService.getMedianIncome(fipsCode.state, fipsCode.county,
				fipsCode.tract, fipsCode.blockGroup));
		ldw.setMedianAge(GovCensusService.getMedianAge(fipsCode.state, fipsCode.county,
				fipsCode.tract, fipsCode.blockGroup));
		ldw.setMarriedCoupleFamilyHouseholds(GovCensusService.getMarriedCoupleFamilyHouseholds(
				fipsCode.state, fipsCode.county, fipsCode.tract, fipsCode.blockGroup));
		ldw.setTotalHouseholds(GovCensusService.getTotalHouseholds(fipsCode.state, fipsCode.county,
				fipsCode.tract, fipsCode.blockGroup));
	}
}
