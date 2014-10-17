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

	public static FipsCode getFipsCode(double latitude, double longitude) {
		FipsCode result = new FipsCode();
		String fipsCode = getBlockFipsCode(latitude, longitude);
		result.state = fipsCode.substring(0, 2);
		result.county = fipsCode.substring(2, 5);
		result.tract = fipsCode.substring(5, 11);
		result.blockGroup = fipsCode.substring(11, 12);
		result.block = fipsCode.substring(11, 15); // this might be wrong, but I'm not using block
		return result;
	}
}
