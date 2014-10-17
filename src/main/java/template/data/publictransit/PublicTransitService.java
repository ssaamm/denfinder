package template.data.publictransit;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import template.data.WebApiService;
import template.util.ApiKeys;

public class PublicTransitService extends WebApiService {
	private static final Logger logger = LogManager.getLogger(PublicTransitService.class);
	private static final String cApiKey = ApiKeys.cWalkscoreKey,
			cTransitBaseUrl = "http://transit.walkscore.com/transit/score/";

	public static Integer getTransitScore(double latitude, double longitude) {
		Integer score = null;
		Map<String, String> params = new HashMap<String, String>();
		params.put("lat", Double.toString(latitude));
		params.put("lon", Double.toString(longitude));
		params.put("wsapikey", cApiKey);
		params.put("research", "yes");

		try {
			logger.debug(encodeUrl(cTransitBaseUrl, params));
			JSONObject apiResponse = getResponseObj(encodeUrl(cTransitBaseUrl, params));
			score = apiResponse.getInt("transit_score");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return score;
	}
}
