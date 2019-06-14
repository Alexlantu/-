package org.alex.entity;

public class ActivitCompanySignupListVo {
	
	private int id;
	private String CompanyName;
	private String companyField;
	private String companyType;
	private String companySize;
	private String homepage;
	private String ContactName;
	private String ContactPhone;
	private String ContactEmail;
	private String ContactWechat;
	private String ContactQQ;
	private String JobinfoDetails;
	private String RecruitmentFilePath;
	
	public ActivitCompanySignupListVo(int id, String companyName, String companyField, String companyType,
			String companySize, String homepage, String contactName, String contactPhone, String contactEmail,
			String contactWechat, String contactQQ, String jobinfoDetails, String recruitmentFilePath) {
		this.id = id;
		CompanyName = companyName;
		this.companyField = companyField;
		this.companyType = companyType;
		this.companySize = companySize;
		this.homepage = homepage;
		ContactName = contactName;
		ContactPhone = contactPhone;
		ContactEmail = contactEmail;
		ContactWechat = contactWechat;
		ContactQQ = contactQQ;
		JobinfoDetails = jobinfoDetails;
		RecruitmentFilePath = recruitmentFilePath;
	}
	
	public ActivitCompanySignupListVo() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getCompanyField() {
		return companyField;
	}

	public void setCompanyField(String companyField) {
		this.companyField = companyField;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
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
		return this.id + "-" + this.CompanyName + "-" + this.companyField + "-" + this.companyType + "-" + this.companySize + "-" + this.homepage + "-" + this.ContactName + "-" + this.ContactPhone + "-" + this.ContactEmail + "-" + this.ContactWechat + "-" + this.ContactQQ + "-" + this.JobinfoDetails + "" + this.RecruitmentFilePath;
	}

}
