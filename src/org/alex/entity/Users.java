package org.alex.entity;

public class Users {
	private String UserID;
	private String UserName;
	private String Gender;
	private String Birthdate;
	private String City;
	private String Major;
	private String DegreeLevel;
	private String GraduateSchool;
	private String Intention;
	private String PhoneNumber;
	private String Email;
	
	public Users() {
		
	}
	
	public Users(String userID, String userName, String gender, String birthdate, String major, String degreeLevel,
			String graduateSchool, String intention, String phoneNumber, String email) {
		UserID = userID;
		UserName = userName;
		Gender = gender;
		Birthdate = birthdate;
		Major = major;
		DegreeLevel = degreeLevel;
		GraduateSchool = graduateSchool;
		Intention = intention;
		PhoneNumber = phoneNumber;
		Email = email;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getBirthdate() {
		return Birthdate;
	}
	public void setBirthdate(String birthdate) {
		Birthdate = birthdate;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getDegreeLevel() {
		return DegreeLevel;
	}
	public void setDegreeLevel(String degreeLevel) {
		DegreeLevel = degreeLevel;
	}
	public String getGraduateSchool() {
		return GraduateSchool;
	}
	public void setGraduateSchool(String graduateSchool) {
		GraduateSchool = graduateSchool;
	}
	public String getIntention() {
		return Intention;
	}
	public void setIntention(String intention) {
		Intention = intention;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	@Override
	public String toString() {
		return this.UserID+"-"+this.UserName+"-"+this.Gender+"-"+this.Birthdate+"-"+this.City+"-"+this.Major+"-"+this.DegreeLevel+"-"+this.GraduateSchool+"-"+this.Intention+"-"+this.PhoneNumber+"-"+this.Email;
	}
	

}
