package app.service;

import java.util.ArrayList;

import app.entity.EmployeeDTO;

public interface EmployeeService {
	
	EmployeeDTO createEmployee(EmployeeDTO empDto);
	EmployeeDTO getEmployeeByID(long id);
	ArrayList<EmployeeDTO> getAllEmployees();
	EmployeeDTO updateEmployee(EmployeeDTO empDto, long id);
	EmployeeDTO deleteEmployee(long id);
	ArrayList<EmployeeDTO> searchEmployees(String ex);
}
