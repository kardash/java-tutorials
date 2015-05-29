package com.jdechmann.proto.camel.converter;

import java.util.List;

import org.apache.camel.Converter;

import com.jdechmann.proto.camel.vo.Candidate;

@Converter
public class CandidateConverter {
	
	@Converter
	public Candidate toCandidate(List<String> personArray) {
		
		Candidate candidate = new Candidate();
		candidate.setName(personArray.get(0));
		candidate.setAge(Integer.valueOf(personArray.get(1)));
		candidate.setSize(Integer.valueOf(personArray.get(2)));
		
		return candidate;
	}
}
