package org.alex.entity;

public class Recruitmentads {
	
	private int recruitmentadsID;
	private String recruitmentadsName;
	private String uploadDate;
	private String filepath;
	
	
	public Recruitmentads(int recruitmentadsID, String recruitmentadsName, String uploadDate, String filepath) {
		this.recruitmentadsID = recruitmentadsID;
		this.recruitmentadsName = recruitmentadsName;
		this.uploadDate = uploadDate;
		this.filepath = filepath;
	}
	
	public Recruitmentads( String recruitmentadsName, String uploadDate, String filepath) {
		this.recruitmentadsName = recruitmentadsName;
		this.uploadDate = uploadDate;
		this.filepath = filepath;
	}

	public Recruitmentads() {
		
	}

	public int getRecruitmentadsID() {
		return recruitmentadsID;
	}

	public void setRecruitmentadsID(int recruitmentadsID) {
		this.recruitmentadsID = recruitmentadsID;
	}

	public String getRecruitmentadsName() {
		return recruitmentadsName;
	}

	public void setRecruitmentadsName(String recruitmentadsName) {
		this.recruitmentadsName = recruitmentadsName;
	}
	
	
	
	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public String toString() {
		return this.recruitmentadsID + "-" + this.recruitmentadsName + "-" + this.uploadDate + "-" + this.filepath;
	}

}
