package app.service;

import java.util.ArrayList;

import app.entity.Employee;
import app.entity.EmployeeDTO;

public class EmployeeMapper {
	
	public static EmployeeDTO mapToEmployeeDTO(Employee emp) {
		return new EmployeeDTO(emp.getId(), emp.getFname(), emp.getLname(), emp.getEmail());
	}
	
	public static Employee mapToEmployee(EmployeeDTO emp) {
		return new Employee(emp.id(), emp.fname(), emp.lname(), emp.email());
	}
	
	public static ArrayList<EmployeeDTO> mapToEmployeeDTOList(ArrayList<Employee> emps) {
		ArrayList<EmployeeDTO> emps2 = new ArrayList<EmployeeDTO>();
		for(var e : emps) {
			emps2.add(mapToEmployeeDTO(e));
		}
		return emps2;
	}

}
