package org.alex.entity;

public class ActivityJobfairsListVo {
	
	private int JobfairID;
	private String Title;
	private int ReleaseSchoolID;
	private String name;
	private String ReleaseDate;
	private String HoldDate;
	
	

	
	public ActivityJobfairsListVo(int jobfairID, String title, int releaseSchoolID, String name, String releaseDate,
			String holdDate) {
		JobfairID = jobfairID;
		Title = title;
		ReleaseSchoolID = releaseSchoolID;
		this.name = name;
		ReleaseDate = releaseDate;
		HoldDate = holdDate;
	}


	public ActivityJobfairsListVo() {
		
	}


	public int getJobfairID() {
		return JobfairID;
	}


	public void setJobfairID(int jobfairID) {
		JobfairID = jobfairID;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}

	

	public int getReleaseSchoolID() {
		return ReleaseSchoolID;
	}


	public void setReleaseSchoolID(int releaseSchoolID) {
		ReleaseSchoolID = releaseSchoolID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getReleaseDate() {
		return ReleaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		ReleaseDate = releaseDate;
	}


	public String getHoldDate() {
		return HoldDate;
	}


	public void setHoldDate(String holdDate) {
		HoldDate = holdDate;
	}
	
	@Override
	public String toString() {
		return this.JobfairID + "-" + this.Title + "-" + this.ReleaseSchoolID + "-" + this.name + "-" + this.ReleaseDate + "-" + this.HoldDate;
	}
}
