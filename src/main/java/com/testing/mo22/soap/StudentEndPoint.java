package com.testing.mo22.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.howtodoinjava.xml.school.StudentDetailsRequest;
import com.howtodoinjava.xml.school.StudentDetailsResponse;

@Endpoint
public class StudentEndPoint {
	
	private static final String NAMESPACE_URL = "http://www.howtodoinjava.com/xml/school";
	
	private StudentRespository studentRepository;
	
	@Autowired
	public StudentEndPoint(StudentRespository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URL, localPart = "StudentDetailsRequest")
	@ResponsePayload
	public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
		StudentDetailsResponse response = new StudentDetailsResponse();
		response.setStudent(studentRepository.findStudent(request.getName()));
		return response;
	}

}
