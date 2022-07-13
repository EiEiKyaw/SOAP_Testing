package com.testing.my22.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.testing.my22.soap.entity.StudentDetailsRequest;
import com.testing.my22.soap.entity.StudentDetailsResponse;
import com.testing.my22.soap.repo.StudentRespository;

@Endpoint
public class StudentEndPoint {
	
	private static final String NAMESPACE_URL = "http://www.testing.com/my22/soap/entity";
	
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
