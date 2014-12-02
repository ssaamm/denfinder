package template.controllers;

import template.m1.LatLon;

public class ScoreResponse {
	private Double score;
	private LatLon location;
	
	public ScoreResponse(Double latitude, Double longitude) {
		location = new LatLon(latitude, longitude);
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public LatLon getLocation() {
		return location;
	}
}
