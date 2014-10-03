package template.data.fipsconversion;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import template.data.WebApiService;

public class FipsConversionService extends WebApiService {
	private static final Logger logger = LogManager.getLogger(FipsConversionService.class);
	private static final String cApiBaseUrl = "http://data.fcc.gov/api/block/find";

	private static String getFipsCode(double latitude, double longitude, String level) {
		String fipsCode = "";
		Map<String, String> params = new HashMap<String, String>();
		params.put("latitude", Double.toString(latitude));
		params.put("longitude", Double.toString(longitude));
		params.put("format", "json");

		try {
			logger.debug(encodeUrl(cApiBaseUrl, params));
			JSONObject apiResponse = getResponseObj(encodeUrl(cApiBaseUrl, params));
			fipsCode = apiResponse.getJSONObject(level).getString("FIPS");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			fipsCode = null;
		}
		return fipsCode;
	}

	public static String getBlockFipsCode(double latitude, double longitude) {
		return getFipsCode(latitude, longitude, "Block");
	}

	public static String getStateFipsCode(double latitude, double longitude) {
		return getFipsCode(latitude, longitude, "State");
	}

	public static String getCountyFipsCode(double latitude, double longitude) {
		return getFipsCode(latitude, longitude, "County");
	}
}
