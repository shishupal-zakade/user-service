package com.microservices.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.example.entiry.User;
import com.microservices.example.repository.UserRepositiry;
import com.microservices.example.vo.Department;
import com.microservices.example.vo.ResponseTemplateVO;

@Service
public class UserService {

	@Autowired
	private UserRepositiry repositiry;

	@Autowired
	private RestTemplate restTemplate;

	public User save(User user) {
		return repositiry.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		Optional<User> oUser = repositiry.findById(userId);
		User user = oUser.get();
		responseTemplateVO.setUser(user);
		String url = "http://DEPARTMENT-SERVICE/department/find/" + user.getUserId();
		System.out.println("Calling URL1 -"+url);
		Department department = restTemplate.
				getForObject(url,
				Department.class);
		responseTemplateVO.setDepartment(department);
		return responseTemplateVO;
	}
}
