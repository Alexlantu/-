package org.alex.entity;

public class ProvinceTimeSalary {
	private String TimeID;
	private String ProvinceID;
	private String Date;
	private String SalaryAvg;
	private String LessFiveK;
	private String FiveToTenK;
	private String TenToFifteenK;
	private String FifteenToTwentyK;
	private String MorethanTwentyK;
	
	public ProvinceTimeSalary(String timeID, String provinceID, String date, String salaryAvg, String lessFiveK,
			String fiveToTenK, String tenToFifteenK, String fifteenToTwentyK, String morethanTwentyK) {
		TimeID = timeID;
		ProvinceID = provinceID;
		Date = date;
		SalaryAvg = salaryAvg;
		LessFiveK = lessFiveK;
		FiveToTenK = fiveToTenK;
		TenToFifteenK = tenToFifteenK;
		FifteenToTwentyK = fifteenToTwentyK;
		MorethanTwentyK = morethanTwentyK;
	}
	
	public ProvinceTimeSalary() {
		
	}

	public String getTimeID() {
		return TimeID;
	}

	public void setTimeID(String timeID) {
		TimeID = timeID;
	}

	public String getProvinceID() {
		return ProvinceID;
	}

	public void setProvinceID(String provinceID) {
		ProvinceID = provinceID;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getSalaryAvg() {
		return SalaryAvg;
	}

	public void setSalaryAvg(String salaryAvg) {
		SalaryAvg = salaryAvg;
	}

	public String getLessFiveK() {
		return LessFiveK;
	}

	public void setLessFiveK(String lessFiveK) {
		LessFiveK = lessFiveK;
	}

	public String getFiveToTenK() {
		return FiveToTenK;
	}

	public void setFiveToTenK(String fiveToTenK) {
		FiveToTenK = fiveToTenK;
	}

	public String getTenToFifteenK() {
		return TenToFifteenK;
	}

	public void setTenToFifteenK(String tenToFifteenK) {
		TenToFifteenK = tenToFifteenK;
	}

	public String getFifteenToTwentyK() {
		return FifteenToTwentyK;
	}

	public void setFifteenToTwentyK(String fifteenToTwentyK) {
		FifteenToTwentyK = fifteenToTwentyK;
	}

	public String getMorethanTwentyK() {
		return MorethanTwentyK;
	}

	public void setMorethanTwentyK(String morethanTwentyK) {
		MorethanTwentyK = morethanTwentyK;
	}
	
	@Override
	public String toString() {
		return this.TimeID + "-" + this.ProvinceID + "-" + this.Date + "-" + this.SalaryAvg + "-" + this.LessFiveK + "-" + this.FiveToTenK + "-" + this.TenToFifteenK + "-" + this.FifteenToTwentyK + "-" + this.MorethanTwentyK;
	}
	
}
