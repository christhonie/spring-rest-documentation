package com.pepkor.integration_sample_api;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
public class ServiceProperties {

	private String defaultTimeZone = "Africa/Johannesburg";

	public String getDefaultTimeZone() {
		return this.defaultTimeZone;
	}

	public void setDefaultTimeZone(String timeZone) {
		this.defaultTimeZone = timeZone;
	}

}
