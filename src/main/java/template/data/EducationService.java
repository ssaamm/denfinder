package template.data;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import template.util.ApiKeys;

public class EducationService extends WebApiService {
	private static final String cApiKey = ApiKeys.cEducationKey,
			cApiBaseUrl = "http://api.education.com/service/service.php";
	
	public static ArrayList<School> getSchools(double latitude, double longitude, double distance) {
		ArrayList<School> schools = new ArrayList<School>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("f", "schoolSearch");
		params.put("key", cApiKey);
		params.put("sn", "sf");
		params.put("v", "4");
		params.put("latitude", Double.toString(latitude));
		params.put("longitude", Double.toString(longitude));
		params.put("distance", Double.toString(distance));
		params.put("resf", "json");
		try {
			System.out.println(encodeUrl(cApiBaseUrl, params));
			JSONArray allSchools = getResponseArr(encodeUrl(cApiBaseUrl, params));
			for (int i = 0; i < allSchools.length(); ++i) {
				JSONObject jsonSchool = allSchools.getJSONObject(i).getJSONObject("school");
				schools.add(SchoolMapper.map(jsonSchool));
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schools;
	}
}
