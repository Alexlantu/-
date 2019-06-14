package org.alex.entity;

public class CompanySignup {
	
	private int CompanyID;
	private int id;
	private String ContactName;
	private String ContactPhone;
	private String ContactEmail;
	private String ContactWechat;
	private String ContactQQ;
	private String JobinfoDetails;
	private String RecruitmentFilePath;
	
	public CompanySignup(int companyID, int id, String contactName, String contactPhone, String contactEmail,
			String contactWechat, String contactQQ, String jobinfoDetails, String recruitmentFilePath) {
		CompanyID = companyID;
		this.id = id;
		ContactName = contactName;
		ContactPhone = contactPhone;
		ContactEmail = contactEmail;
		ContactWechat = contactWechat;
		ContactQQ = contactQQ;
		JobinfoDetails = jobinfoDetails;
		RecruitmentFilePath = recruitmentFilePath;
	}
	
	public CompanySignup(String contactName, String contactPhone, String contactEmail,
			String contactWechat, String contactQQ, String jobinfoDetails, String recruitmentFilePath) {
		ContactName = contactName;
		ContactPhone = contactPhone;
		ContactEmail = contactEmail;
		ContactWechat = contactWechat;
		ContactQQ = contactQQ;
		JobinfoDetails = jobinfoDetails;
		RecruitmentFilePath = recruitmentFilePath;
	}
	
	public CompanySignup() {
		
	}

	public int getCompanyID() {
		return CompanyID;
	}

	public void setCompanyID(int companyID) {
		CompanyID = companyID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContactName() {
		return ContactName;
	}

	public void setContactName(String contactName) {
		ContactName = contactName;
	}

	public String getContactPhone() {
		return ContactPhone;
	}

	public void setContactPhone(String contactPhone) {
		ContactPhone = contactPhone;
	}

	public String getContactEmail() {
		return ContactEmail;
	}

	public void setContactEmail(String contactEmail) {
		ContactEmail = contactEmail;
	}

	public String getContactWechat() {
		return ContactWechat;
	}

	public void setContactWechat(String contactWechat) {
		ContactWechat = contactWechat;
	}

	public String getContactQQ() {
		return ContactQQ;
	}

	public void setContactQQ(String contactQQ) {
		ContactQQ = contactQQ;
	}

	public String getJobinfoDetails() {
		return JobinfoDetails;
	}

	public void setJobinfoDetails(String jobinfoDetails) {
		JobinfoDetails = jobinfoDetails;
	}

	public String getRecruitmentFilePath() {
		return RecruitmentFilePath;
	}

	public void setRecruitmentFilePath(String recruitmentFilePath) {
		RecruitmentFilePath = recruitmentFilePath;
	}

	@Override
	public String toString() {
		return this.CompanyID + "-" + this.id + "-" + this.ContactName + "-" + this.ContactPhone + "-" + this.ContactEmail + "-" + this.ContactWechat + "-" + this.ContactQQ + "-" + this.JobinfoDetails + "-" + this.RecruitmentFilePath;
	}
	
}
