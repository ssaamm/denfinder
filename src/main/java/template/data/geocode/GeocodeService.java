package template.data.geocode;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import template.data.WebApiService;
import template.data.publictransit.PublicTransitService;
import template.m1.LatLon;
import template.util.ApiKeys;

public class GeocodeService extends WebApiService {
	private static final Logger logger = LogManager.getLogger(PublicTransitService.class);
	private static final String cApiKey = ApiKeys.cGoogleGeocodeKey,
			cGeocodeBaseUrl = "https://maps.googleapis.com/maps/api/geocode/json";

	public static LatLon getLatLon(String address){
		LatLon result = new LatLon();
		Map<String, String> params = new HashMap<String, String>();
		params.put("address", address);
		params.put("key", cApiKey);

		try {
			logger.debug(encodeUrl(cGeocodeBaseUrl, params));
			JSONObject apiResponse = getResponseObj(encodeUrl(cGeocodeBaseUrl, params));
			logger.debug(apiResponse.toString(4));
			JSONArray results = apiResponse.getJSONArray("results");
			if (results.length() < 1) {
				return result;
			}
			JSONObject location = results.getJSONObject(0)
					.getJSONObject("geometry").getJSONObject("location");
			result.setLatitude(location.getDouble("lat"));
			result.setLongitude(location.getDouble("lng"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
