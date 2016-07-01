package com.pepkor.integration_sample_api;

import java.util.Date;
import java.util.List;

public class GetMeetingResponse {
    private final String subject;
    private final Date startTime;
    private final Date endTime;
    private final String timezone;
    private final List<String> names;
	private List<String> conflicts;

	public GetMeetingResponse(String subject, Date startTime, Date endTime, String timezone, List<String> names, List<String> conflicts) {
		super();
		this.subject = subject;
		this.startTime = startTime;
		this.endTime = endTime;
		this.timezone = timezone;
		this.names = names;
		this.conflicts = conflicts;
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

	public List<String> getConflicts() {
		return conflicts;
	}
}
