package com.Project.SpringAngular.Service;


import com.Project.SpringAngular.DTO.EmployeeDTO;
import com.Project.SpringAngular.DTO.LoginDTO;
import com.Project.SpringAngular.responce.LoginMesage;



 
public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);
 
    LoginMesage loginEmployee(LoginDTO loginDTO);
 
}

