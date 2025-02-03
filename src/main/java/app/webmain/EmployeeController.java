package app.webmain;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.entity.EmployeeDTO;
import app.service.EmpSerImp;

@Component("idk")
@RestController
@RequestMapping("/api/emp")
@CrossOrigin(origins = {"http://localhost:8080"})
public class EmployeeController {
	
	@Autowired
	private EmpSerImp empSer;

	//Api mappings
	@PostMapping("/create")
	public ResponseEntity<EmployeeDTO> createEmp(@RequestBody EmployeeDTO epmDTO){
		var savedEmp = empSer.createEmployee(epmDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmp);
	}
	
	@GetMapping("/show/{id}")
	public ResponseEntity<EmployeeDTO> getEmpById(@PathVariable long id){
		var emp = empSer.getEmployeeByID(id);
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	
	@GetMapping("/showall")
	public ResponseEntity<ArrayList<EmployeeDTO>> getAllEmps(){
		var emps = empSer.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(emps);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDTO> updateEmp(@RequestBody EmployeeDTO epmDTO, @PathVariable long id){
		var savedEmp = empSer.updateEmployee(epmDTO, id);
		return ResponseEntity.status(HttpStatus.OK).body(savedEmp);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<EmployeeDTO> deleteEmpById(@PathVariable long id){
		var emp = empSer.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	
	@GetMapping("/query/{ex}")
	public ResponseEntity<ArrayList<EmployeeDTO>> queryEmps(@PathVariable String ex){
		var emps = empSer.searchEmployees(ex);
		return ResponseEntity.status(HttpStatus.OK).body(emps);
	}
}
