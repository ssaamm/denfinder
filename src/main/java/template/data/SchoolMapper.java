package template.data;

import org.json.JSONException;
import org.json.JSONObject;

public class SchoolMapper {

	public static School map(JSONObject jsonSchool) {
		School school = new School();
		try {
			school.schoolId = jsonSchool.getString("schoolid");
			school.schoolName = jsonSchool.getString("schoolname");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return school;
	}

}
