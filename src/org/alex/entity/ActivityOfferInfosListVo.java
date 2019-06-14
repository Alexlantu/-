package org.alex.entity;

public class ActivityOfferInfosListVo {
	
	private int CompanyID;
	private int JobID;
	private String CompanyName;
	private String JobName;
	private String JobType;
	private String Salary;
	private String SalaryLow;
	private String SalaryHigh;
	private String CityName;
	private String WorkExpName;
	private String eduLevelName;
	private String IfFulltime;
	private String Welfares;
	

	public ActivityOfferInfosListVo(int companyID, int jobID, String companyName, String jobName, String jobType,
			String salary, String salaryLow, String salaryHigh, String cityName, String workExpName,
			String eduLevelName, String ifFulltime, String welfares) {
		CompanyID = companyID;
		JobID = jobID;
		CompanyName = companyName;
		JobName = jobName;
		JobType = jobType;
		Salary = salary;
		SalaryLow = salaryLow;
		SalaryHigh = salaryHigh;
		CityName = cityName;
		WorkExpName = workExpName;
		this.eduLevelName = eduLevelName;
		IfFulltime = ifFulltime;
		Welfares = welfares;
	}


	public ActivityOfferInfosListVo() {
		
	}

	
	
	
	public int getCompanyID() {
		return CompanyID;
	}


	public void setCompanyID(int companyID) {
		CompanyID = companyID;
	}


	public int getJobID() {
		return JobID;
	}


	public void setJobID(int jobID) {
		JobID = jobID;
	}


	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getJobName() {
		return JobName;
	}

	public void setJobName(String jobName) {
		JobName = jobName;
	}

	
	public String getJobType() {
		return JobType;
	}

	public void setJobType(String jobType) {
		JobType = jobType;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}
	
	

	public String getSalaryLow() {
		return SalaryLow;
	}


	public void setSalaryLow(String salaryLow) {
		SalaryLow = salaryLow;
	}


	public String getSalaryHigh() {
		return SalaryHigh;
	}


	public void setSalaryHigh(String salaryHigh) {
		SalaryHigh = salaryHigh;
	}


	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getWorkExpName() {
		return WorkExpName;
	}

	public void setWorkExpName(String workExpName) {
		WorkExpName = workExpName;
	}

	public String getEduLevelName() {
		return eduLevelName;
	}

	public void setEduLevelName(String eduLevelName) {
		this.eduLevelName = eduLevelName;
	}

	public String getIfFulltime() {
		return IfFulltime;
	}

	public void setIfFulltime(String ifFulltime) {
		IfFulltime = ifFulltime;
	}

	public String getWelfares() {
		return Welfares;
	}

	public void setWelfares(String welfares) {
		Welfares = welfares;
	}
	
	@Override
	public String toString() {
		return this.CompanyID + "-" + this.JobID + "-" + this.CompanyName + "-" + this.JobName + "-" + this.JobType + "-" +this.Salary + "-" + this.SalaryLow + "-" + this.SalaryHigh + "-" + this.CityName + "-" + this.WorkExpName + "-" + this.eduLevelName + "-" + this.IfFulltime + "-" + this.Welfares;
	}

}
