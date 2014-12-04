package template.data.education;

import org.json.JSONException;
import org.json.JSONObject;

public class SchoolMapper {

	public static School map(JSONObject jsonSchool) {
		School school = new School();
		try {
			school.testRatingText = jsonSchool.getString("testrating_text");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return school;
	}

}
