package com.samsoft.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MockDocSettingGenerator {
	
	List<DocSettings> docs = null;

	public MockDocSettingGenerator() {
		
	}

	public List<DocSettings> createMockDocks() throws IOException{
		docs = new ArrayList<DocSettings>();
		String fileLink = "http://www.africau.edu/images/default/sample.pdf";
		docs.add(new DocSettings(1,"sam","1200",fileLink,true,1,true,"landscape","lazer"));
		return docs;
	}
	
}
