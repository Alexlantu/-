package org.alex.entity;

public class Province {

	private String ProvinceID;
	private String ProvinceName;
	private String PinYin;
	private String SalaryAvg;
	private String LessFiveK;
	private String FiveToTenK;
	private String TenToFifteenK;
	private String FifteenToTwentyK;
	private String MorethanTwentyK;
	private String url;
	
	
	


	public Province(String provinceID, String provinceName, String pinYin, String salaryAvg, String lessFiveK,
			String fiveToTenK, String tenToFifteenK, String fifteenToTwentyK, String morethanTwentyK, String url) {
		ProvinceID = provinceID;
		ProvinceName = provinceName;
		PinYin = pinYin;
		SalaryAvg = salaryAvg;
		LessFiveK = lessFiveK;
		FiveToTenK = fiveToTenK;
		TenToFifteenK = tenToFifteenK;
		FifteenToTwentyK = fifteenToTwentyK;
		MorethanTwentyK = morethanTwentyK;
		this.url = url;
	}

	public Province() {
	
	}

	public String getProvinceID() {
		return ProvinceID;
	}

	public void setProvinceID(String provinceID) {
		ProvinceID = provinceID;
	}

	public String getProvinceName() {
		return ProvinceName;
	}

	public void setProvinceName(String provinceName) {
		ProvinceName = provinceName;
	}
	
	

	public String getPinYin() {
		return PinYin;
	}

	public void setPinYin(String pinYin) {
		PinYin = pinYin;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return this.ProvinceID + "-" + this.ProvinceName + this.PinYin + "-" + this.SalaryAvg + this.LessFiveK + "-" + this.FiveToTenK + "-" + this.TenToFifteenK + "-" +this.FifteenToTwentyK + "-" +this.MorethanTwentyK + "-" + this.url;
	}
	
}
