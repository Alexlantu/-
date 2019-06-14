package org.alex.entity;

public class University {
	
	private int id;
	private String name;
	private int province_id;
	private String level;
	private String website;
	private String abbreviation;
	private String city;
	
	public University(int id, String name, int province_id, String level, String website, String abbreviation,
			String city) {
		this.id = id;
		this.name = name;
		this.province_id = province_id;
		this.level = level;
		this.website = website;
		this.abbreviation = abbreviation;
		this.city = city;
	}
	
	public University() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProvince_id() {
		return province_id;
	}

	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		
		return this.id+"-"+this.name+"-"+this.province_id+"-"+this.level+"-"+this.website+"-"+this.abbreviation+"-"+this.city;
		
	}
	
	

}
