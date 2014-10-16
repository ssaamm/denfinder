package template.scoring;

public class SubScore {
	private String area;
	private double weight;//0,1,2,3,4,5
	private double rawScore;//0 - 1
	
	public SubScore(){
		area = "";
		this.weight = 1;
		this.rawScore = .5;
	}
	
	public SubScore(double w, double raw, String a){
		this.weight = w;
		this.rawScore = raw;
		this.area = a;
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getRawScore() {
		return rawScore;
	}
	public void setRawScore(double rawScore) {
		this.rawScore = rawScore;
	}
	
	public double getSubScore(){
		return weight*rawScore;
	}
	
}
