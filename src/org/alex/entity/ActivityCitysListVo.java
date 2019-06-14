package org.alex.entity;

public class ActivityCitysListVo {
	
	private String CityID;
	private String CityName;
	private String LevelName;
	private String ProvinceName;
	private String SalaryAvg;
	
	
	public ActivityCitysListVo(String cityID, String cityName, String levelName, String provinceName,
			String salaryAvg) {
		CityID = cityID;
		CityName = cityName;
		LevelName = levelName;
		ProvinceName = provinceName;
		SalaryAvg = salaryAvg;
	}
	
	public ActivityCitysListVo() {

	}

	public String getCityID() {
		return CityID;
	}

	public void setCityID(String cityID) {
		CityID = cityID;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getLevelName() {
		return LevelName;
	}

	public void setLevelName(String levelName) {
		LevelName = levelName;
	}

	public String getProvinceName() {
		return ProvinceName;
	}

	public void setProvinceName(String provinceName) {
		ProvinceName = provinceName;
	}

	public String getSalaryAvg() {
		return SalaryAvg;
	}

	public void setSalaryAvg(String salaryAvg) {
		SalaryAvg = salaryAvg;
	}
	
	

}
