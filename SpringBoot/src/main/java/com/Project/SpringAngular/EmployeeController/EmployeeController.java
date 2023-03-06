package com.Project.SpringAngular.EmployeeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.SpringAngular.DTO.EmployeeDTO;
import com.Project.SpringAngular.DTO.LoginDTO;
import com.Project.SpringAngular.Service.EmployeeService;
import com.Project.SpringAngular.responce.LoginMesage;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		
		String id = employeeService.addEmployee(employeeDTO);
		return id;
		
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
		
		LoginMesage loginMesage = employeeService.loginEmployee(loginDTO);
		return ResponseEntity.ok(loginMesage);
		
	}
}
