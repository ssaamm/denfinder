package template.data.govcensus;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;

import template.data.WebApiService;
import template.data.census.CensusService;
import template.util.ApiKeys;

public class GovCensusService extends WebApiService {
	private static final Logger logger = LogManager.getLogger(CensusService.class);
	private static final String cApiKey = ApiKeys.cGovCensusKey,
			cAcsBaseUrl = "http://api.census.gov/data/2012/acs5";

	private static Integer getInteger(String state, String county, String tract, String blockGroup,
			String key) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", cApiKey);
		params.put("for", "block+group:" + blockGroup);
		params.put("in", String.format("state:%s+county:%s+tract:%s", state, county, tract));
		params.put("get", key);

		try {
			logger.debug(encodeUrl(cAcsBaseUrl, params, false));
			JSONArray apiResponse = getResponseArr(encodeUrl(cAcsBaseUrl, params, false));
			for (int i = 1; i < apiResponse.length(); ++i) {
				result.add(new Integer(apiResponse.getJSONArray(i).getString(0)));
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result.size() < 1) {
			return null;
		}
		return result.get(0);
	}

	public static GovData getCensusData(String state, String county, String tract, String blockGroup) {
		ArrayList<GovData> result = new ArrayList<GovData>();
		String[] attributesToGet = { "B19013_001E", "B01002_001E", "B11001_003E", "B11001_001E" };
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", cApiKey);
		params.put("for", "block+group:" + blockGroup);
		params.put("in", String.format("state:%s+county:%s+tract:%s", state, county, tract));
		params.put("get", String.join(",", attributesToGet));

		try {
			logger.debug(encodeUrl(cAcsBaseUrl, params, false));
			JSONArray apiResponse = getResponseArr(encodeUrl(cAcsBaseUrl, params, false));
			for (int i = 1; i < apiResponse.length(); ++i) {
				JSONArray arr = apiResponse.getJSONArray(i);
				Integer B19013_001E = null;
				try {
					B19013_001E = arr.getInt(0);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				Double B01002_001E = null;
				try {
					B01002_001E = arr.getDouble(1);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				Integer B11001_003E = arr.getInt(2);
				Integer B11001_001E = arr.getInt(3);
				result.add(new GovData(B19013_001E, B01002_001E, B11001_003E, B11001_001E));
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result.size() < 1) {
			return null;
		}
		return result.get(0);
	}

	// TODO: This shouldn't be an entirely separate method
	private static Double getDouble(String state, String county, String tract, String blockGroup,
			String key) {
		ArrayList<Double> result = new ArrayList<Double>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", cApiKey);
		params.put("for", "block+group:" + blockGroup);
		params.put("in", String.format("state:%s+county:%s+tract:%s", state, county, tract));
		params.put("get", key);

		try {
			logger.debug(encodeUrl(cAcsBaseUrl, params, false));
			JSONArray apiResponse = getResponseArr(encodeUrl(cAcsBaseUrl, params, false));
			for (int i = 1; i < apiResponse.length(); ++i) {
				result.add(new Double(apiResponse.getJSONArray(i).getString(0)));
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result.size() < 1) {
			return null;
		}
		return result.get(0);
	}

	public static Integer getMedianIncome(String state, String county, String tract,
			String blockGroup) {
		return getInteger(state, county, tract, blockGroup, "B19013_001E");
	}

	public static Double getMedianAge(String state, String county, String tract, String blockGroup) {
		return getDouble(state, county, tract, blockGroup, "B01002_001E");
	}

	public static Integer getMarriedCoupleFamilyHouseholds(String state, String county,
			String tract, String blockGroup) {
		return getInteger(state, county, tract, blockGroup, "B11001_003E");
	}

	public static Integer getTotalHouseholds(String state, String county, String tract,
			String blockGroup) {
		return getInteger(state, county, tract, blockGroup, "B11001_001E");
	}

}
