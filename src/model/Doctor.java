package model;

public class Doctor {

	private String doctorName;
	private String doctorSpecialty;
	private String area;
	// assume 1, 2, 3, 4, 5 for review score
	private Integer score;

	public Doctor(String doctorName, String doctorSpecialty) {
		this.doctorName = doctorName;
		this.doctorSpecialty = doctorSpecialty;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getDoctorSpecialty() {
		return doctorSpecialty;
	}

	public Integer getScore() {
		return score;
	}

	public String getArea() {
		return area;
	}

	public String toString() {
		return (doctorName + "" + doctorSpecialty);
	}

}
