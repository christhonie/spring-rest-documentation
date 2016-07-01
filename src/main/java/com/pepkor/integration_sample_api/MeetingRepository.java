package com.pepkor.integration_sample_api;

import java.util.List;
import java.util.UUID;

import org.joda.time.Interval;
import org.springframework.stereotype.Repository;

@Repository
public class MeetingRepository {
	
	/**
	 * Book a meeting against one or more users
	 * @param names - List of users in meeting
	 * @param interval - Start and end times
	 * @return Meeting identifier
	 */
	public String bookMeeting(List<String> names, Interval interval) {
		//TODO Add implementation here
		return UUID.randomUUID().toString();
	}
	
	public Boolean cancelMeeting(String meetingId) {
		//TODO Add implementation here
		return true;
	}

}
