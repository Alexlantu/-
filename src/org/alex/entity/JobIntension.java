package org.alex.entity;

public class JobIntension {
	
	private int jobintensionid;
	private String IndustryID;
	private String JobName;
	private String JobType;
	private String WorkplaceHope;
	private String SalaryReq;
	private String WorkingTime;
	private String UserID;
	
	
	public JobIntension(int jobintensionid, String IndustryID, String JobName, String JobType, String WorkplaceHope, String SalaryReq,
			String WorkingTime, String UserID) {
		this.jobintensionid = jobintensionid;
		this.IndustryID = IndustryID;
		this.JobName = JobName;
		this.JobType = JobType;
		this.WorkplaceHope = WorkplaceHope;
		this.SalaryReq = SalaryReq;
		this.WorkingTime = WorkingTime;
		this.UserID = UserID;
	}
	
	public JobIntension(String IndustryID, String JobName, String JobType, String WorkplaceHope, String SalaryReq,
			String WorkingTime, String UserID) {
		this.IndustryID = IndustryID;
		this.JobName = JobName;
		this.JobType = JobType;
		this.WorkplaceHope = WorkplaceHope;
		this.SalaryReq = SalaryReq;
		this.WorkingTime = WorkingTime;
		this.UserID = UserID;
	}
	
	public JobIntension() {
	
	}
	
	

	public int getJobintensionid() {
		return jobintensionid;
	}

	public void setJobintensionid(int jobintensionid) {
		this.jobintensionid = jobintensionid;
	}

	public String getIndustryID() {
		return IndustryID;
	}

	public void setIndustryID(String IndustryID) {
		this.IndustryID = IndustryID;
	}

	public String getJobName() {
		return JobName;
	}

	public void setJobName(String JobName) {
		this.JobName = JobName;
	}

	public String getJobType() {
		return JobType;
	}

	public void setJobType(String JobType) {
		this.JobType = JobType;
	}

	public String getWorkplaceHope() {
		return WorkplaceHope;
	}

	public void setWorkplaceHope(String WorkplaceHope) {
		this.WorkplaceHope = WorkplaceHope;
	}

	public String getSalaryReq() {
		return SalaryReq;
	}

	public void setSalaryReq(String SalaryReq) {
		this.SalaryReq = SalaryReq;
	}

	public String getWorkingTime() {
		return WorkingTime;
	}

	public void setWorkingTime(String WorkingTime) {
		this.WorkingTime = WorkingTime;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String UserID) {
		this.UserID = UserID;
	}
	
	@Override
	public String toString() {
		return this.IndustryID + "-" + this.JobName + "-" + this.JobType + "-" +this.WorkplaceHope + "-" +this.SalaryReq + "-" + this.WorkingTime + "-" +this.UserID;
	}
	

}
