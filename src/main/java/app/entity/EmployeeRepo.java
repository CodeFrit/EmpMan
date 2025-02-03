package app.entity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	List<Employee> findByFname(String fname);
}
