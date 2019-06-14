package org.alex.entity;

public class OfferInfos {
	
	private int CompanyID;
	private int JobID;
	private String JobName;
	private String JobType;
	private String Salary;
	private String WorkCityID;
	private String WorkExpID;
	private String eduLevelID;
	private String IfFulltime;
	private String Welfares;
	
	
	
	public OfferInfos(int companyID, int jobID, String jobName, String jobType, String salary,
			String workCityID, String workExpID, String eduLevelID, String ifFulltime, String welfares) {
		CompanyID = companyID;
		JobID = jobID;
		JobName = jobName;
		JobType = jobType;
		Salary = salary;
		WorkCityID = workCityID;
		WorkExpID = workExpID;
		this.eduLevelID = eduLevelID;
		IfFulltime = ifFulltime;
		Welfares = welfares;
	}

	public OfferInfos() {
		
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

	public String getWorkCityID() {
		return WorkCityID;
	}

	public void setWorkCityID(String workCityID) {
		WorkCityID = workCityID;
	}

	public String getWorkExpID() {
		return WorkExpID;
	}

	public void setWorkExpID(String workExpID) {
		WorkExpID = workExpID;
	}

	public String getEduLevelID() {
		return eduLevelID;
	}

	public void setEduLevelID(String eduLevelID) {
		this.eduLevelID = eduLevelID;
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
		return this.getCompanyID() + "-" + this.getJobID() + "-" + this.getJobName() + "-" + this.getJobType() + "-" + this.getSalary() + "-" + this.getWorkCityID() + "-" + this.getWorkExpID() + "-" + this.getEduLevelID() + "-" + this.getIfFulltime() + "-" + this.getWelfares();
	}

}
