package template.data;

public class School {
	public String schoolId;
	public String schoolName;
	public String zip;
	public String address;
	public String city;
	public int districtId;
	public int districtLeaId;
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
	public int ncesId;
	public String url;
	public String testRatingText;
	public String testRatingImageLarge;
	public String testRatingImageSmall;
	public int testRatingYear;
	
	public String toString() {
		return schoolId + " " + schoolName;
	}
}
