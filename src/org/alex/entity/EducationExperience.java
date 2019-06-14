package org.alex.entity;

public class EducationExperience {
	
	private String schoolname;
	private String inschooltime;
	private String outschooltime;
	private String degreelevel;
	private String major;
	private String userid;
	
	
	public EducationExperience(String schoolname, String inschooltime, String outschooltime, String degreelevel,
			String major, String userid) {
		this.schoolname = schoolname;
		this.inschooltime = inschooltime;
		this.outschooltime = outschooltime;
		this.degreelevel = degreelevel;
		this.major = major;
		this.userid = userid;
	}
	
	public EducationExperience() {
		
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getInschooltime() {
		return inschooltime;
	}

	public void setInschooltime(String inschooltime) {
		this.inschooltime = inschooltime;
	}

	public String getOutschooltime() {
		return outschooltime;
	}

	public void setOutschooltime(String outschooltime) {
		this.outschooltime = outschooltime;
	}

	public String getDegreelevel() {
		return degreelevel;
	}

	public void setDegreelevel(String degreelevel) {
		this.degreelevel = degreelevel;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return this.schoolname + "-" + this.inschooltime + "-" + this.outschooltime + "-" + this.degreelevel + "-" + this.major + "-" + this.userid;
	}

}
