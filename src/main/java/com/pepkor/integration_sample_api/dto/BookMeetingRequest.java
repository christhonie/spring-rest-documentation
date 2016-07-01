package com.pepkor.integration_sample_api.dto;

import java.util.Date;
import java.util.List;

/**
 * Request structure for scheduling a meeting.
 * Immutable DTO
 * @author Christhonie
 *
 */
public class BookMeetingRequest {
    private final String subject;
    private final Date startTime;
    private final Date endTime;
    private final String timezone;
    private final List<String> names;

	public BookMeetingRequest(String subject, Date startTime, Date endTime, String timezone, List<String> names) {
		super();
		this.subject = subject;
		this.startTime = startTime;
		this.endTime = endTime;
		this.timezone = timezone;
		this.names = names;
	}

    public String getSubject() {
		return subject;
	}
	public Date getStartTime() {
		return startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public String getTimezone(){
		return this.timezone;
	}

	public List<String> getNames() {
		return names;
	}
}
