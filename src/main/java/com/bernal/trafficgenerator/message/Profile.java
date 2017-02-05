package com.bernal.trafficgenerator.message;

public class Profile {
	private String name;
	private Integer numberOfElements;
	private String type;
	private String organization;
	private String model;
	private String location;
	
	// period
	private Long mean;
	private Long stdev;
	
	// optional session params
	private Boolean sessionTime;
	
	public String getName() {
		return name;
	}
	public Integer getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getMean() {
		return mean;
	}
	public void setMean(Long mean) {
		this.mean = mean;
	}
	public Long getStdev() {
		return stdev;
	}
	public void setStdev(Long stdev) {
		this.stdev = stdev;
	}
	public Boolean getSessionTime() {
		return sessionTime;
	}
	public void setSessionTime(Boolean sessionTime) {
		this.sessionTime = sessionTime;
	}
	
}
