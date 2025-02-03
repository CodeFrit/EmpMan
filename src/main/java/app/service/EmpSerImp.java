package app.service;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entity.Employee;
import app.entity.EmployeeDTO;
import app.entity.EmployeeRepo;

@Service
public class EmpSerImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepo emprepo;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO empDto) {
		
		Employee emp = EmployeeMapper.mapToEmployee(empDto);
		Employee savedEmp = emprepo.save(emp);
		return EmployeeMapper.mapToEmployeeDTO(savedEmp);
	}

	@Override
	public EmployeeDTO getEmployeeByID(long id) {
		var emp = emprepo.findById(id).orElseThrow(()->new EmployeeException("Employee not found"));
		return EmployeeMapper.mapToEmployeeDTO(emp);
	}

	@Override
	public ArrayList<EmployeeDTO> getAllEmployees() {
		var emps = (ArrayList<Employee>) emprepo.findAll();
		return EmployeeMapper.mapToEmployeeDTOList( emps);
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO empDto, long id) {
		var emp = emprepo.findById(id).orElseThrow(()->new EmployeeException("Employee not found"));
		emp.setFname(empDto.fname());
		emp.setLname(empDto.lname());
		emp.setEmail(empDto.email());
		var empS = emprepo.save(emp);
		return EmployeeMapper.mapToEmployeeDTO(empS);
	}

	@Override
	public EmployeeDTO deleteEmployee(long id) {
		var del = emprepo.findById(id).orElseThrow(()->new EmployeeException("Employee not found"));
		emprepo.deleteById(id);
		return EmployeeMapper.mapToEmployeeDTO(del);
	}

	@Override
	public ArrayList<EmployeeDTO> searchEmployees(String ex) {
		var emps = (ArrayList<Employee>) emprepo.findByFname(ex);
		if(emps.size()>0) {
			return EmployeeMapper.mapToEmployeeDTOList(emps);
		}else {
			throw new EmployeeException("No employees found");
		}
	}
}
