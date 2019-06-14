package org.alex.entity;

public class Jobfairs {

	private int JobfairID;
	private String Title;
	private String ReleaseSchool;
	private String ReleaseDate;
	private String HoldDate;
	
	public Jobfairs(int jobfairID, String title, String releaseSchool, String releaseDate, String holdDate) {
		JobfairID = jobfairID;
		Title = title;
		ReleaseSchool = releaseSchool;
		ReleaseDate = releaseDate;
		HoldDate = holdDate;
	}
	
	public Jobfairs(String title, String releaseSchool, String releaseDate, String holdDate) {
		Title = title;
		ReleaseSchool = releaseSchool;
		ReleaseDate = releaseDate;
		HoldDate = holdDate;
	}
	
	public Jobfairs() {

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

	public String getReleaseSchool() {
		return ReleaseSchool;
	}

	public void setReleaseSchool(String releaseSchool) {
		ReleaseSchool = releaseSchool;
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
		return this.JobfairID + "-" + this.Title + "-" + this.ReleaseSchool + "-" + this.ReleaseDate + "-" + this.HoldDate;
	}
}
