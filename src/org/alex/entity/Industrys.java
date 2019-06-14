package org.alex.entity;

public class Industrys {
	
	private String IndustryID;
	private String IndustryName;
	
	public Industrys(String industryID, String industryName) {
		IndustryID = industryID;
		IndustryName = industryName;
	}
	
	public Industrys() {

	}

	public String getIndustryID() {
		return IndustryID;
	}

	public void setIndustryID(String industryID) {
		IndustryID = industryID;
	}

	public String getIndustryName() {
		return IndustryName;
	}

	public void setIndustryName(String industryName) {
		IndustryName = industryName;
	}
	
	@Override
	public String toString() {
		return this.IndustryID + "-" + this.IndustryName;
	}
	
}
