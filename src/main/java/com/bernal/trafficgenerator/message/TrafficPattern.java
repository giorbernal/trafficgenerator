package com.bernal.trafficgenerator.message;

import java.util.ArrayList;
import java.util.List;

public class TrafficPattern {
	
	private List<String> organizations = new ArrayList<String>();
	private List<String> msgTypes = new ArrayList<String>();
	private List<String> models = new ArrayList<String>();
	
	private Time time;
	
	private List<Profile> profiles = new ArrayList<Profile>(); 
	
	public List<String> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<String> organizations) {
		this.organizations = organizations;
	}

	public List<String> getMsgTypes() {
		return msgTypes;
	}

	public void setMsgTypes(List<String> msgTypes) {
		this.msgTypes = msgTypes;
	}

	public List<String> getModels() {
		return models;
	}

	public void setModels(List<String> models) {
		this.models = models;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	
	public void validate() throws Throwable {
		for (Profile profile : profiles) {
			if (!organizations.contains(profile.getOrganization()))
				throw new Throwable("organization " + profile.getOrganization() + " does not exist");
			if (!models.contains(profile.getModel()))
				throw new Throwable("model " + profile.getModel() + " does not exist");
			if (!msgTypes.contains(profile.getType()))
				throw new Throwable("mssssssg type " + profile.getType() + " does not exist");
			if (!models.contains(profile.getModel()))
				throw new Throwable("model " + profile.getModel() + " does not exist");
			
			
		}
	}

}
