package com.pepkor.integration_sample_api.dto;

import java.util.List;

public class BookMeetingResponse {
	private final String meetingId;
	private final List<String> conflicts;
	
	public BookMeetingResponse(String meetingId, List<String> conflicts) {
		super();
		this.meetingId = meetingId;
		this.conflicts = conflicts;
	}

	public String getMeetingId() {
		return meetingId;
	}

	public List<String> getConflicts() {
		return conflicts;
	}
}
