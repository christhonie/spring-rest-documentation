package com.pepkor.integration_sample_api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ResourceRepository {
	public List<Resource> allResources() {
		List<Resource> resources = new ArrayList<Resource>(5);
		
		resources.add(new Resource("Christhonie Geldenhuys", ResourceCategory.PERSON, "cgeldenhuys@dearx.co.za"));
		resources.add(new Resource("Bertus Botha", ResourceCategory.PERSON, "cgeldenhuys@dearx.co.za"));
		resources.add(new Resource("Jonathan Lewis", ResourceCategory.PERSON, "jlewis@dearx.co.za"));
		resources.add(new Resource("Projector A01", ResourceCategory.DEVICE, "projector_a01@pepkorit.com"));
		resources.add(new Resource("Giga", ResourceCategory.ROOM, "RM_giga@pepkorit.com"));
		
		return resources;
	}

}
