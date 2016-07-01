package com.pepkor.integration_sample_api;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pepkor.integration_sample_api.dto.BookMeetingRequest;
import com.pepkor.integration_sample_api.dto.BookMeetingResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
//@Api(value="/meeting")
public class MeetingService {

	@Autowired
	MeetingRepository meetingService;
	@Autowired
	ResourceRepository resources;
	
    @RequestMapping(method = RequestMethod.POST, path="/meeting/checkAvailability", produces = "application/json")
    public String checkAvailability(@RequestParam(value="name", defaultValue="") String name) {
        return "User " + name + " is available";
    }
    
    @RequestMapping("/meeting/book")
    //@ApiOperation(value = "bookMeeting", nickname = "bookMeeting")
    public BookMeetingResponse bookMeeting(@RequestParam(value="request") BookMeetingRequest request) {
    	String meetingId = meetingService.bookMeeting(
    			request.getNames(), 
    			new Interval(
    					new DateTime(request.getStartTime(), DateTimeZone.forID(request.getTimezone())),
    					new DateTime(request.getEndTime(), DateTimeZone.forID(request.getTimezone()))));
        return new BookMeetingResponse(meetingId, null);
    }
    
    @RequestMapping(value = "/meeting", method = RequestMethod.GET)
    public GetMeetingResponse getMeeting(@RequestParam(value="meetingId") String meetingId) {
    	return null;
    }

    @RequestMapping(value = "/resources/search", method = RequestMethod.GET)
    public ResponseEntity<String> search(@RequestParam(value = "resource") ResourceCategory resource) {
      return ResponseEntity.ok(resource.name());
    }

//    @RequestMapping(value = "/category/map", method = RequestMethod.GET)
//    public Map<String, Map<String, Pet>> map() {
//      return newHashMap();
//    }
//
//    @RequestMapping(value = "/meeting/{id}", method = RequestMethod.POST)
//    public ResponseEntity<Void> someOperation(@PathVariable long id, @RequestBody int userId) {
//      return ResponseEntity.ok(null);
//    }

}
	