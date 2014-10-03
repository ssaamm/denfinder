package template.m1;

public class LatLon {
	private Double latitude = 31.5472, longitude = -97.1139;

	public LatLon() {
	}
	public LatLon(Double lat, Double lon) {
		latitude = lat;
		longitude = lon;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "(" + latitude + ", " + longitude + ")";
	}
}
