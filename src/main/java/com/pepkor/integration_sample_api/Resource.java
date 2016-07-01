package com.pepkor.integration_sample_api;

public class Resource {
	private String name;
	private ResourceCategory category;
	private String email;
	
	public Resource(String name, ResourceCategory category, String email) {
		super();
		this.name = name;
		this.category = category;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ResourceCategory getCategory() {
		return category;
	}
	public void setCategory(ResourceCategory category) {
		this.category = category;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
