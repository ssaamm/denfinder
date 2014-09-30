package template.data.census;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import template.data.WebApiService;
import template.util.ApiKeys;

public class CensusService extends WebApiService {
	private static final Logger logger = LogManager.getLogger(CensusService.class);
	private static final String cApiKey = ApiKeys.cCensusKey,
			cApiBaseUrl = "http://api.usatoday.com/open/census/loc";

	public static ArrayList<Place> getPlaces(String state) {
		ArrayList<Place> places = new ArrayList<Place>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("api_key", cApiKey);
		params.put("keypat", state);
		params.put("sumlevid", "4,6");
		
		try {
			logger.debug(encodeUrl(cApiBaseUrl, params));
			JSONObject apiResponse = getResponseObj(encodeUrl(cApiBaseUrl, params));
			JSONArray allPlaces = apiResponse.getJSONArray("response");
			for (int i = 0; i < allPlaces.length(); ++i) {
				JSONObject jsonPlace = allPlaces.getJSONObject(i);
				logger.debug(jsonPlace.toString(4));
				places.add(PlaceMapper.map(jsonPlace));
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return places;
	}

}
