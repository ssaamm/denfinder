package template.data.education;

public class School {
	public String schoolId;
	public String schoolName;
	public String zip;
	public String address;
	public String city;
	public String districtId;
	public String districtLeaId;
	public boolean aypResult;
	public int aypResultYear;
	public double distance;
	public int totalEnrollment;
	public String gradeLevel;
	public String gradesServed;
	public double latitude;
	public double longitude;
	public String phoneNumber;
	public String schoolDistrictName;
	public String schoolType;
	public String state;
	public int totalStudentTeacherRatio;
	public String website;
	public String ncesId;
	public String url;
	public String testRatingText;
	public String testRatingImageLarge;
	public String testRatingImageSmall;
	public String testRatingYear;

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", score=" + getQuality() + "]";
	}

	public int getQuality() {
		String rating = "0";
		String[] split = testRatingText.split("\\s+");
		if (split.length >= 3) {
			rating = split[2];
		}
		return Integer.valueOf(rating);
	}
}
