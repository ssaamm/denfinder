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
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", zip=" + zip
				+ ", address=" + address + ", city=" + city + ", districtId=" + districtId
				+ ", districtLeaId=" + districtLeaId + ", aypResult=" + aypResult
				+ ", aypResultYear=" + aypResultYear + ", distance=" + distance
				+ ", totalEnrollment=" + totalEnrollment + ", gradeLevel=" + gradeLevel
				+ ", gradesServed=" + gradesServed + ", latitude=" + latitude + ", longitude="
				+ longitude + ", phoneNumber=" + phoneNumber + ", schoolDistrictName="
				+ schoolDistrictName + ", schoolType=" + schoolType + ", state=" + state
				+ ", totalStudentTeacherRatio=" + totalStudentTeacherRatio + ", website=" + website
				+ ", ncesId=" + ncesId + ", url=" + url + ", testRatingText=" + testRatingText
				+ ", testRatingImageLarge=" + testRatingImageLarge + ", testRatingImageSmall="
				+ testRatingImageSmall + ", testRatingYear=" + testRatingYear + "]";
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
