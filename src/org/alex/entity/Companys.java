package org.alex.entity;

public class Companys {
	
	private int companyID;
	private String companyName;
	private String companyField;
	private String companyType;
	private String companySize;
	private String homepage;
	private String companyLogoLink;
	
	public Companys() {
		
	}
	
	public Companys(int companyID, String companyName, String companyField, String companyType, String companySize,
			String homepage, String companyLogoLink) {
		this.companyID = companyID;
		this.companyName = companyName;
		this.companyField = companyField;
		this.companyType = companyType;
		this.companySize = companySize;
		this.homepage = homepage;
		this.companyLogoLink = companyLogoLink;
	}

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getCompanyLogoLink() {
		return companyLogoLink;
	}

	public void setCompanyLogoLink(String companyLogoLink) {
		this.companyLogoLink = companyLogoLink;
	}
	
	@Override
	public String toString() {
		return this.companyID + "-" + this.companyName + "-" +this.companyField + "-" + this.companyType + "-" + this.companySize + "-" + this.homepage + "-" + this.companyLogoLink; 
	}
	
	

}
